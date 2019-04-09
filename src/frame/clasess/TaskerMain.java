package frame.clasess;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import task.classes.UploadFolderTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TaskerMain extends JFrame {

	private String xmlPath = "C:\\nvbackupService\\TasksConfig.xml";
	private JPanel contentPane;
	private JTable table;
	private Object[][] dataForTable = getDataTable("BackupAndUploadTask",xmlPath) ;
	
	

	/** UNCOMMENT TO TEST EACH PART
	 * Launch the application
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//
//					TaskerMain frame = new TaskerMain();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
	public TaskerMain() {
		
		String columnNames[] = {"row","Task Name","Task Start","Task End"}; //radi ostavit

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(600,550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Task Configurer");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(224, 11, 128, 38);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 216, 554, 186);
		contentPane.add(scrollPane);
		
		String[] comboOption= {"BackupAndUploadTask","UploadFolderTask"};
		JComboBox comboBox = new JComboBox(comboOption);
		comboBox.setBounds(21, 169, 161, 20);
		contentPane.add(comboBox);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				String selected = comboBox.getSelectedItem().toString();
				table = new JTable(getDataTable(selected,xmlPath),columnNames);
				scrollPane.setViewportView(table);
				
			}
		});
		
		
		JButton btnAddNewTask = new JButton("Add new Task");
		btnAddNewTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				NewTask taskAdd = new NewTask();
				taskAdd.setVisible(true);
				
				
				String selected = comboBox.getSelectedItem().toString();
				table = new JTable(getDataTable(selected,xmlPath),columnNames);
				scrollPane.setViewportView(table);
			}
		});
		btnAddNewTask.setBounds(404, 136, 141, 23);
		contentPane.add(btnAddNewTask);
		
		JButton btnEditTask = new JButton("Edit Task");
		btnEditTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UploadFolderTask a = new UploadFolderTask();
				JTextField b = new JTextField();
				String selectedTaskForEdit = comboBox.getSelectedItem().toString();
				int selectedTableRow = table.getSelectedRow() != -1 ? table.getSelectedRow() : 0;  
				
				if(table.getSelectedRow() == -1)
					JOptionPane.showMessageDialog(null, "You must select row of table before edit!");
				else {
				EditTask editTask = new EditTask(selectedTaskForEdit,selectedTableRow);
					editTask.setVisible(true);
				}
			}
		});
		btnEditTask.setBounds(375, 168, 89, 23);
		contentPane.add(btnEditTask);
		
		JButton btnDeleteTask = new JButton("Delete Task");
		btnDeleteTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedTableRow = table.getSelectedRow(); 
				String selectedTask = comboBox.getSelectedItem().toString();
				
				System.out.println(selectedTableRow + "  " + selectedTask);

				deleteSelected(selectedTableRow,selectedTask); //prosljedivat pravu vrijednost 
			}
		});
		btnDeleteTask.setBackground(Color.RED);
		btnDeleteTask.setForeground(Color.BLACK);
		btnDeleteTask.setBounds(469, 168, 105, 23);
		contentPane.add(btnDeleteTask);
		
		
		String[] pomocniZaIspitivanje  = {"rand","task1","---"," bl"}; /// obrisat kasniuje
		
		//Object[][] data = getDataTable();
		
		table = new JTable(dataForTable,columnNames);
		scrollPane.setViewportView(table);
		
		JButton btnShowLogs = new JButton("Show logs");
		btnShowLogs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogShowerDialog logShowerDialog = new LogShowerDialog();
				logShowerDialog.setVisible(true);
			}
		});
		btnShowLogs.setBounds(236, 110, 98, 23);
		contentPane.add(btnShowLogs);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] script = {"cmd.exe","/c","sc","start","NVBackupService"};
				
				try {
					Process process = Runtime.getRuntime().exec(script);
					System.out.println("Succesfully started NVBackupService");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStart.setForeground(Color.GREEN);
		btnStart.setBounds(20, 51, 89, 23);
		contentPane.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] script = {"cmd.exe","/c","sc","stop","NVBackupService"};
				
				try {
					Process process = Runtime.getRuntime().exec(script);
					System.out.println("Succesfully stoped NVBackupService");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnStop.setForeground(Color.RED);
		btnStop.setBounds(469, 51, 89, 23);
		contentPane.add(btnStop);
		
		JButton btnRefreshTable = new JButton("Refresh Table");
		btnRefreshTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String selected = comboBox.getSelectedItem().toString();
				table = new JTable(getDataTable(selected,xmlPath),columnNames);
				scrollPane.setViewportView(table);
				
			}
		});
		btnRefreshTable.setBackground(new Color(34, 139, 34));
		btnRefreshTable.setForeground(Color.BLACK);
		btnRefreshTable.setBounds(206, 168, 128, 23);
		contentPane.add(btnRefreshTable);
		
		JLabel lblChoseTasksTo = new JLabel("Chose tasks to show");
		lblChoseTasksTo.setBounds(45, 151, 110, 14);
		contentPane.add(lblChoseTasksTo);
		

		
	
		
	
	}
	
	
	//mozda nece trebat//99
	private void loadData(String selectedTask){
		
		//ProducDAO productDao = new ProductDao();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		
	}
	
	private void xmlToObject() {
		
	
	}
	
	private static Object[][] getDataTable(String selectedTask,String xmlPath)
	{
		
		Object[][] dataTable = new Object[10][4];
		
		//trebadeklasiObject[] ;
	    //Parser that produces DOM object trees from XML content
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	     
	    //API to obtain DOM Document instance
	    DocumentBuilder builder = null;
	    try
	    {
	        //Create DocumentBuilder with default configuration
	        builder = factory.newDocumentBuilder();
	         
	        //Parse the content to Document object
	        Document doc = builder.parse(new File(xmlPath));
	        
	        
	        System.out.println("parsed  "  );
	        NodeList nodeList = doc.getElementsByTagName(selectedTask); // proslijediti u ovisnosti koji se hvataju
	        
	        
	        System.out.println(nodeList.getLength());
	        for(int i=0;i<nodeList.getLength();i++) {
	        	
	        	Node node = nodeList.item(i);
	        	
	        	Element elementSubMain = (Element) node;
	        	
	        	
	        	
	        	NodeList childNodeList = node.getChildNodes(); 
	        	
	        
	        	
	        	System.out.println("----------------------------------Datum pocetni" );
	        	for(int j=0;j<childNodeList.getLength();j++) {
	        		
	        		Node childNode = childNodeList.item(j); //hvatanje taskova(backup ili upload--u ovisnosti )
	        		
	        	
	        		
	        		NodeList arrayOfTasksElement = childNode.getChildNodes(); // hvatanja u listu nodova svih elemenata taska
	        		
	        		Element childElement = (Element) childNode;
	        		
	        		
	        		//childElement.getNodeName().equals("TaskStart");
	        		
	        			
	        		
	        		String childNodeName = childElement.getNodeName();
	        		
	        		String atributes = childElement.getAttribute("value"); // atributes for catching
	        		
	        		
	        		
	        		if(childElement.getNodeName().equals("TaskStart")) {
	        			dataTable[i][2] = atributes;
	        		}
	        		
	        		if(childElement.getNodeName().equals("TaskEnd")) {
	        			dataTable[i][3] = atributes;
	        		}
	        		
	        		if(childElement.getNodeName().equals("Name")) {
	        			dataTable[i][1] = atributes;
	        		}
	        		
	        		
	        		System.out.println(j  +". podnodName:   "+"atribut:  " + atributes + "  " + childNodeName); //podNod je ustvari podchild(fieldov Taska)
	        	}
	        	
	        	dataTable[i][0]= i+1; // hvatanje rowa
	        	
	        	
	        	System.out.println("----------------------------------");
	        	
	        	Element element = (Element) node;
	        	
	        	//String atributes = element.getAttribute("value");
	        	
	        	
	        	
		        System.out.println("child nodes " + i + ". "+node.getNodeName() +"duzina child noda" + childNodeList.getLength());
		        
		       
	        }
	        
	        	 
	        return dataTable;
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	private static void writtingToFile(Document document) {
		
		String xmlFilePath = "C:\\nvbackupService\\TasksConfig.xml";
		 //transform the DOM Object to an XML File
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer;
		try {
			transformer = transformerFactory.newTransformer();
			   DOMSource domSource = new DOMSource(document);
		        StreamResult streamResult = new StreamResult(new File(xmlFilePath));

		        try {
					transformer.transform(domSource, streamResult);
					System.out.println("Done creating XML File");
				} catch (TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		       
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
		
	}
	
	
	
	//trenutno ne radi, kopirano iz getdatatable
	private static void deleteSelected(Integer selectedRow, String selectedTask) {
		
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	     
	    //API to obtain DOM Document instance
	    DocumentBuilder builder = null;
	    try
	    {
	        //Create DocumentBuilder with default configuration
	        builder = factory.newDocumentBuilder();
	         
	        //Parse the content to Document object
	        Document doc = builder.parse(new File("C:\\nvbackupService\\TasksConfig.xml"));
	      
  
	        System.out.println("parsed  "  );
	        NodeList nodeList = doc.getElementsByTagName(selectedTask); // proslijediti u ovisnosti koji se hvataju
	        
	        
	        System.out.println("duzina prije brisanja" + nodeList.getLength());
	        
	        //ova petlja redudantna za delete vjerovatno obrisat
	        for(int i=0;i<nodeList.getLength();i++) {
	        	
	        	Node node = nodeList.item(i);
	        	
	        	if(i==selectedRow)
	        		node.getParentNode().removeChild(node); // trebalo bii obrisat----------------------glavna proba delete
	        	
	        	
	        	Element elementSubMain = (Element) node;
	        	
	        	
	        	
	        	NodeList childNodeList = node.getChildNodes(); 
	        	
	        
	        	
	        	System.out.println("----------------------------------Datum pocetni" );
	        	for(int j=0;j<childNodeList.getLength();j++) {
	        		
	        		Node childNode = childNodeList.item(j); //hvatanje taskova(backup ili upload--u ovisnosti )
	        		
	        		
	        		NodeList arrayOfTasksElement = childNode.getChildNodes(); // hvatanja u listu nodova svih elemenata taska
	        		
	        		Element childElement = (Element) childNode;
	        		
	        		
	        		//childElement.getNodeName().equals("TaskStart");
	        		
	        			
	        		
	        		String childNodeName = childElement.getNodeName();
	        		
	        		String atributes = childElement.getAttribute("value"); // atributes for catching
	        		
	        		
	        		
	        		System.out.println(j  +". podnodName:   "+"atribut:  " + atributes + "  " + childNodeName); //podNod je ustvari podchild(fieldov Taska)
	        	}
	        	
	        	
	        	
	        	
	        	System.out.println("----------------------------------");
	        	System.out.println("duzina poslije brisanja" + nodeList.getLength());
	        	
	        	Element element = (Element) node;
	        	
	        	//String atributes = element.getAttribute("value");
	        	
	        	
	        	
		        System.out.println("child nodes " + i + ". "+node.getNodeName() +"duzina child noda" + childNodeList.getLength());
		        
		       
	        }
	        writtingToFile(doc);
	        	 

	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	  
		
		
		
	}
}
