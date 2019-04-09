package frame.clasess;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LogShowerDialog extends JDialog {
	private JTable table;
	private String selecteLogFileToView ="";// stavit mozda new string
	private JComboBox comboBox = new JComboBox();
	private Object[][] dataTable;
	

	/**
	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			LogShowerDialog dialog = new LogShowerDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	/**
//	 * Create the dialog.
//	 */
	public LogShowerDialog() {
		
		String[] columnNames = {"row","Task Name","Task Start","Task Details"};
		//mozda ostavitObject[][] dataTable = parseLogFile();
		
		ArrayList<String> listFiLeNames = getLogFileNames();
		
		int numberOfFiles = listFiLeNames.size();
		
		String[] fileNamesArray = new String[numberOfFiles];
		
		String logPath = "C:\\nvbackupService\\Logs\\" + fileNamesArray[0];
		
		
		for(int i=0;i< listFiLeNames.size();i++) {
			
			fileNamesArray[i] = listFiLeNames.get(i);
		}
		
	
	
		selecteLogFileToView =fileNamesArray[0]; 
		
	
		dataTable = parseLogFile(selecteLogFileToView);
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 93, 331, 139);
		getContentPane().add(scrollPane);
		
		table = new JTable(dataTable,columnNames);
		scrollPane.setViewportView(table);
		
		//JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(fileNamesArray));
		comboBox.setBounds(38, 47, 220, 20);
		//comboBox.setBounds(21, 169, 161, 20);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("promje");
				
				selecteLogFileToView = comboBox.getSelectedItem().toString();
				dataTable = parseLogFile(selecteLogFileToView);
				table = new JTable(dataTable,columnNames);
				scrollPane.setViewportView(table);
				System.out.println("promjenjeno na " + selecteLogFileToView);
//				String selected = comboBox.getSelectedItem().toString();
//				table = new JTable(getDataTable(selected,xmlPath),columnNames);
//				scrollPane.setViewportView(table);
				
			}
		});
		
		getContentPane().add(comboBox);
		
		JLabel lblLogs = new JLabel("Logs");
		lblLogs.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLogs.setBounds(156, 11, 76, 34);
		getContentPane().add(lblLogs);
		
		//parseLogFile();
		
		int count = new File("C:\\nvbackupService\\Logs").list().length;
		System.out.println("Number of file : " + count);
		
		//parseLogFile(logPath);
	}
	
	private static Object[][] parseLogFile(String pr) {
		Object[][] dataTable = new Object[10][4];
		
		String xmlFilePath = "C:\\nvbackupService\\Logs\\" + pr;
		try{
			   FileInputStream fstream = new FileInputStream(xmlFilePath);
			   BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			   String strLine;
			   int i=0;
			   br.readLine();			   /* for skiping log line */
			   br.readLine();
			  String z= br.readLine();  
			  System.err.println("readed: " + z);
			   
			   while ((strLine = br.readLine()) != null && i<6)   {
			     /* parse strLine to obtain what you want */
				 dataTable[i][0] = i;
				
				 dataTable[i][1] = strLine.split(":")[3];
				 
				 dataTable[i][2] = strLine.split(":")[0];
				 
				 dataTable[i][3] = strLine.split(":")[4];
				 
				 String forIspis = strLine.split(":")[4];
			     System.out.println (forIspis);
			     i++;
			   }
			   fstream.close();
			   return dataTable;
			} catch (Exception e) {
			     System.err.println("Error: " + e.getMessage());
			}
		return null;
	}
	
	private static ArrayList<String>  getLogFileNames() {
		
		File folder = new File("C:\\nvbackupService\\Logs");
		File[] listOfFiles = folder.listFiles();
		
		ArrayList<String> listFiLeNames = new ArrayList<String>();
		String[] logFiles = {};
		
		for (int i = 0; i < listOfFiles.length; i++) {
			  if (listOfFiles[i].isFile()) {
				  listFiLeNames.add(listOfFiles[i].getName());
			    System.out.println("File " + listOfFiles[i].getName());
			  } else if (listOfFiles[i].isDirectory()) {
			    System.out.println("Directory " + listOfFiles[i].getName());
			  }
			}
		
		return listFiLeNames;
		
	}
}
