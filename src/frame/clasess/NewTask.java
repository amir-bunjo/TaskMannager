package frame.clasess;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import task.classes.UploadFolderTask;

import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class NewTask extends JDialog {
	private JTextField databaseFolderNameField;
	private JTextField dropBoxClearField;
	private JTextField folderPathField;
	private JTextField nameField;
	private JTextField taskActiveField;
	private JTextField taskStartField;
	private JTextField taskEndField;
	private JTextField taskRepeatField;
	private JTextField databaseTypeField;
	private JTextField sqlConnectionField;
	private JTextField sqlDatabaseField;
	private JTextField backupsFolderField;
	private JButton btnSubmit;
	private String[] arrayOfTasksName;
	
	private UploadFolderTask[] uploadFolderTaskArray;
	private JLabel lblDatabaseType;
	private JLabel lblSqlconnectionstring;
	private JLabel lblSqldatabasename;
	private JLabel lblBackupsFolder;
	private JLabel lblLocalFolder;
	private JTextField clearDayField;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			NewTask dialog = new NewTask();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//	}

	/**
	 * Create the dialog.
	 */
	public NewTask() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JLabel lblAddNewTask = new JLabel("Add New Task");
			lblAddNewTask.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblAddNewTask.setBounds(282, 5, 165, 27);
			getContentPane().add(lblAddNewTask);
		}
		{
			databaseFolderNameField = new JTextField();
			databaseFolderNameField.setBounds(21, 91, 86, 20);
			
			getContentPane().add(databaseFolderNameField);
			databaseFolderNameField.setColumns(10);
		}
		{
			dropBoxClearField = new JTextField();
			dropBoxClearField.setBounds(21, 135, 86, 20);
			getContentPane().add(dropBoxClearField);
			dropBoxClearField.setColumns(10);
		}
		{
			folderPathField = new JTextField();
			folderPathField.setBounds(21, 181, 86, 20);
			getContentPane().add(folderPathField);
			folderPathField.setColumns(10);
		}
		{
			nameField = new JTextField();
			nameField.setBounds(107, 31, 86, 20);
			getContentPane().add(nameField);
			nameField.setColumns(10);
		}
		{
			taskActiveField = new JTextField();
			taskActiveField.setBounds(288, 91, 86, 20);
			getContentPane().add(taskActiveField);
			taskActiveField.setColumns(10);
		}
		{
			taskStartField = new JTextField();
			taskStartField.setBounds(288, 135, 86, 20);
			getContentPane().add(taskStartField);
			taskStartField.setColumns(10);
		}
		{
			taskEndField = new JTextField();
			taskEndField.setBounds(288, 181, 86, 20);
			getContentPane().add(taskEndField);
			taskEndField.setColumns(10);
		}
		{
			taskRepeatField = new JTextField();
			taskRepeatField.setBounds(288, 230, 86, 20);
			getContentPane().add(taskRepeatField);
			taskRepeatField.setColumns(10);
		}
		{
			databaseTypeField = new JTextField();
			databaseTypeField.setBounds(21, 230, 86, 20);
			getContentPane().add(databaseTypeField);
			databaseTypeField.setColumns(10);
		}
		{
			sqlConnectionField = new JTextField();
			sqlConnectionField.setBounds(147, 91, 86, 20);
			getContentPane().add(sqlConnectionField);
			sqlConnectionField.setColumns(10);
		}
		{
			sqlDatabaseField = new JTextField();
			sqlDatabaseField.setBounds(147, 135, 86, 20);
			getContentPane().add(sqlDatabaseField);
			sqlDatabaseField.setColumns(10);
		}
		{
			backupsFolderField = new JTextField();
			backupsFolderField.setBounds(147, 181, 86, 20);
			getContentPane().add(backupsFolderField);
			backupsFolderField.setColumns(10);
		}
		{
			JLabel lblDatabaseFolderName = new JLabel("Database Folder name");
			lblDatabaseFolderName.setBounds(0, 74, 115, 14);
			getContentPane().add(lblDatabaseFolderName);
		}
		{
			JLabel lblDropBoxClear = new JLabel("Drop Box Clear");
			lblDropBoxClear.setBounds(21, 122, 86, 13);
			getContentPane().add(lblDropBoxClear);
		}
		{
			btnSubmit = new JButton("Submit");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String forEmpty ="";
					String clearDay =  clearDayField.getText();
					
					String taskNameToAdd = comboBox.getSelectedItem().toString();
					
				//	String taskNameToAdd = nameField.getText();
					
					String[] arrayUploadFolderTaskValues = {databaseFolderNameField.getText(),dropBoxClearField.getText(),folderPathField.getText(),
							nameField.getText(),taskActiveField.getText(),taskStartField.getText(),taskEndField.getText(),
							taskRepeatField.getText(),"valuezadji"};
					
					String[] arrayBackupAndUploadValues = {databaseFolderNameField.getText(),dropBoxClearField.getText(),
							databaseTypeField.getText(),sqlConnectionField.getText(),sqlDatabaseField.getText(),
							backupsFolderField.getText(),backupsFolderField.getText(),backupsFolderField.getText(),
							forEmpty,forEmpty,clearDay,clearDay,clearDay,clearDay,clearDay,nameField.getText(),taskActiveField.getText(),
							taskStartField.getText(),taskEndField.getText(),
							taskRepeatField.getText(),"valuezadji"};
					
					for(int i=0;i<21;i++)
					System.out.println(i+"."+ arrayBackupAndUploadValues[i] + ",");
					
					
					
					if(taskNameToAdd.equals("BackupAndUploadTask") )
						writingToOriginDocument(arrayBackupAndUploadValues,taskNameToAdd);
					else
						writingToOriginDocument(arrayUploadFolderTaskValues,taskNameToAdd);
					
				}
			});
			btnSubmit.setBounds(285, 30, 89, 23);
			getContentPane().add(btnSubmit);
		}
		
		JLabel lblFolderpath = new JLabel("FolderPath");
		lblFolderpath.setBounds(21, 160, 74, 20);
		getContentPane().add(lblFolderpath);
		
		JLabel lblName = new JLabel("New Task Name");
		lblName.setBounds(21, 34, 90, 14);
		getContentPane().add(lblName);
		
		JLabel lblTaskactive = new JLabel("TaskActive");
		lblTaskactive.setBounds(309, 74, 46, 14);
		getContentPane().add(lblTaskactive);
		
		JLabel lblTaskstart = new JLabel("TaskStart");
		lblTaskstart.setBounds(298, 121, 64, 14);
		getContentPane().add(lblTaskstart);
		
		JLabel lblTaskend = new JLabel("TaskEnd");
		lblTaskend.setBounds(309, 163, 46, 14);
		getContentPane().add(lblTaskend);
		
		JLabel lblTaskrepeat = new JLabel("TaskRepeat");
		lblTaskrepeat.setBounds(298, 212, 63, 14);
		getContentPane().add(lblTaskrepeat);
		{
			lblDatabaseType = new JLabel("Database Type");
			lblDatabaseType.setBounds(21, 205, 105, 14);
			getContentPane().add(lblDatabaseType);
		}
		{
			lblSqlconnectionstring = new JLabel("SqlConnectionString");
			lblSqlconnectionstring.setBounds(147, 74, 96, 14);
			getContentPane().add(lblSqlconnectionstring);
		}
		{
			lblSqldatabasename = new JLabel("SqlDatabaseName");
			lblSqldatabasename.setBounds(147, 121, 86, 14);
			getContentPane().add(lblSqldatabasename);
		}
		{
			lblBackupsFolder = new JLabel("Backups Folder");
			lblBackupsFolder.setBounds(147, 166, 86, 14);
			getContentPane().add(lblBackupsFolder);
		}
		{
			lblLocalFolder = new JLabel("Clear Day Amount");
			lblLocalFolder.setBounds(147, 212, 96, 14);
			getContentPane().add(lblLocalFolder);
		}
		{
			clearDayField = new JTextField();
			clearDayField.setBounds(147, 230, 86, 20);
			getContentPane().add(clearDayField);
			clearDayField.setColumns(10);
		}
		{
			String[] comboOption= {"BackupAndUploadTask","UploadFolderTask"};
			comboBox = new JComboBox(comboOption);
			comboBox.setBounds(89, 10, 143, 20);
			getContentPane().add(comboBox);
		}
		
		JLabel lblSelectType = new JLabel("Select type");
		lblSelectType.setBounds(21, 13, 74, 14);
		getContentPane().add(lblSelectType);
	}
	
	
	//reading Xml file and saving to Document Object // obrisat vjerovatno
	private static void readXmlFile() throws ParserConfigurationException  {
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		Document doc;
		try {
			doc = docBuilder.parse("C:\\nvbackupService\\noviXml.xml");
			

			Node rootNode = doc.getFirstChild();
			System.out.println(rootNode.getLocalName());
			System.out.println(doc.toString());
			
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static void writingToOriginDocument(String[] array,String taskName) {
		
		String xmlFilePath = "C:\\nvbackupService\\TasksConfig.xml";
		
		String[] pomocniArray = {"2" , " 3"}; // mozda ga obrisat, a promejnit ime sigurno
		
		File file = new File(xmlFilePath);
		  if (file.exists()){
		  DocumentBuilderFactory fact = 
		  DocumentBuilderFactory.newInstance();
		  try {
			DocumentBuilder builder = fact.newDocumentBuilder();
			  try {
				Document doc = builder.parse(xmlFilePath);
				 Node node = doc.getDocumentElement();
				  String root = node.getNodeName();
				  System.out.println("Root Node: " + root);
				  writtingToFile(addNewElement(doc,array,taskName));  /// konacno upisivanje u dokument
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		  }//closing tag for if
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

		        // If you use
		        // StreamResult result = new StreamResult(System.out);
		        // the output will be pushed to the standard output ...
		        // You can use that for debugging 

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
	
	
	// promjenit naziv(pravi se za add u file)
	public static Document addNewElement(Document document,String[] array,String taskAddName) {
		
		String[] arrayTasksValue = array; //copping vjerovatno cu obrisat
		
		String[] arrayValuesNames;
		
		String[] uploadFolderTaskElements = {"DropBoxFolderName","DropBoxClear","FolderPath","Name","TaskActive","TaskStart",
				"TaskEnd","TaskRepeat","TaskLast"};
		
		String[] arrayForElementNames = uploadFolderTaskElements;
		
		String[] uploadBackupAndUploadTask = {"DropBoxFolderName","DropBoxClear","DatabaseType","SqlConnectionString",
				"SqlDatabaseName","BackupFolder","RemoteFolder","LocalFolder","BackupFolder1","BackupFolder2",
				"ClearRemoteFolder","ClearLocalFolder","ClearBackupFolder1","ClearBackupFolder2" ,"ClearBackupsFolder",
				"Name","TaskActive","TaskStart","TaskEnd","TaskRepeat","TaskLast"};
		Node rootNode = document.getFirstChild();
		
	
		
//		//mozda obrisat ----------------------
//		NamedNodeMap earthAttributes = rootNode.getAttributes();
//		Attr galaxy = document.createAttribute("galaxy");
//		galaxy.setValue("milky way");
//		earthAttributes.setNamedItem(galaxy);
//		//----------------------------------
		
		
		// nodes
		
		Node newNode = document.createElement(taskAddName);
		
		
		rootNode.appendChild(newNode);
		
		
		
	

		
		if(taskAddName.equals("BackupAndUploadTask"))
			 arrayValuesNames = uploadBackupAndUploadTask;
		else
				arrayValuesNames = uploadFolderTaskElements;
		
		for(int i=0;i<arrayTasksValue.length;i++) {
			
			Element newElement = document.createElement(arrayValuesNames[i]);
			newElement.setAttribute("value", array[i]);

			newNode.appendChild(newElement);
		}
		
		return document;
		
	}
	
	

	public JTextField getTextField() {
		return databaseFolderNameField;
	}

	public void setTextField(JTextField textField) {
		this.databaseFolderNameField = textField;
	}

	public  JTextField getTextField_1() {
		return dropBoxClearField;
	}

	public void setTextField_1(JTextField textField_1) {
		this.dropBoxClearField = textField_1;
	}

	public String[] getArrayOfTasksName() {
		return arrayOfTasksName;
	}

	public void setArrayOfTasksName(String[] arrayOfTasksName) {
		this.arrayOfTasksName = arrayOfTasksName;
	}
	
	
	
	
	//mozda nece trebat
	public void setArrayOfTasksWithInputedValue() {
		
		//this.arrayOfTasksName = { this.getTextField(), getTextField_1()}
	}
}
