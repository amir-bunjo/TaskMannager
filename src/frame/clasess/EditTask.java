package frame.clasess;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import task.classes.BackupAndUploadTask;
import task.classes.UploadFolderTask;


// copied from ADD TASK
public class EditTask extends JDialog {
	
	
	private String path = "C:\\nvbackupService\\TasksConfig.xml";
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
	
	private Node nodeForReplace;
	private Integer selected;
	private BackupAndUploadTask backupAndUploadTaskPr ;//= getSelectedTaskObjectFormDrugiTip("BackupAndUploadTask","C:\\nvbackupService\\TasksConfig.xml");

	
	private UploadFolderTask uploadFolderTaskPrivate;// = getSelectedTaskObjectForm("UploadFolderTask","C:\\nvbackupService\\TasksConfig.xml",this.selected);
	


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			
//			System.out.println("iz objekta backups and upload" );
//			//uploadFolderTaskPrivate = getDataTable("UploadFolderTask","C:\\nvbackupService\\TasksConfig.xml");
//			UploadFolderTask uploadFolderTask = new UploadFolderTask();
//			EditTask dialog = new EditTask("UploadFolderTask",0); // mogloo bi zabagat zb
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
	public EditTask(String selectedTypeForEdit, Integer selectedTask) {
		
		
		if(selectedTypeForEdit == "BackupAndUploadTask")
			backupAndUploadTaskPr = getSelectedTaskObjectFormDrugiTip("BackupAndUploadTask","C:\\nvbackupService\\TasksConfig.xml",selectedTask);
		else
			uploadFolderTaskPrivate = getSelectedTaskObjectForm("UploadFolderTask","C:\\nvbackupService\\TasksConfig.xml",selectedTask);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		{
			JLabel lblAddNewTask = new JLabel("Edit Task");
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
			nameField.setBounds(95, 10, 140, 20);
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
					String taskNameToAdd = nameField.getText();
					
					String[] uploadFolderTaskElements = {"DropBoxFolderName","DropBoxClear","FolderPath","Name","TaskActive","TaskStart",
							"TaskEnd","TaskRepeat","TaskLast"};
				
					
					String[] backupAndUploadTaskElement = {"DropBoxFolderName","DropBoxClear","DatabaseType","SqlConnectionString",
							"SqlDatabaseName","BackupFolder","RemoteFolder","LocalFolder","BackupFolder1","BackupFolder2",
							"ClearRemoteFolder","ClearLocalFolder","ClearBackupFolder1","ClearBackupFolder2" ,"ClearBackupsFolder",
							"Name","TaskActive","TaskStart","TaskEnd","TaskRepeat","TaskLast"};
					
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
					
					if(selectedTypeForEdit=="BackupAndUploadTask")
						replaceNode(selectedTypeForEdit,selectedTask,arrayBackupAndUploadValues,backupAndUploadTaskElement);
					else if(selectedTypeForEdit=="UploadFolderTask")
						replaceNode(selectedTypeForEdit,selectedTask,arrayUploadFolderTaskValues,uploadFolderTaskElements);
						
					
				
					
				}
			});
			btnSubmit.setBounds(285, 30, 89, 23);
			getContentPane().add(btnSubmit);
		}
		
		JLabel lblFolderpath = new JLabel("FolderPath");
		lblFolderpath.setBounds(21, 160, 74, 20);
		getContentPane().add(lblFolderpath);
		
		JLabel lblName = new JLabel("Task Name");
		lblName.setBounds(10, 13, 90, 14);
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
		// setting value to fields 
		
		if(selectedTypeForEdit == "UploadFolderTask") {
			this.databaseFolderNameField.setText(uploadFolderTaskPrivate.getDropBoxFolderName());
			this.dropBoxClearField.setText(uploadFolderTaskPrivate.getDropBoxClear()!=null ? uploadFolderTaskPrivate.getDropBoxClear().toString() : "");
			this.folderPathField.setText(uploadFolderTaskPrivate.getFolderPath());
			this.nameField.setText(uploadFolderTaskPrivate.getName());
			this.taskActiveField.setText(uploadFolderTaskPrivate.isTaskActive() ? "true": "false");
			this.taskStartField.setText(uploadFolderTaskPrivate.getTaskStart());
			this.taskEndField.setText(uploadFolderTaskPrivate.getTaskEnd());
			this.taskRepeatField.setText(uploadFolderTaskPrivate.getTaskRepeat() != -1 ? uploadFolderTaskPrivate.getTaskRepeat().toString() : "");
		}
		
		if(selectedTypeForEdit == "BackupAndUploadTask") { //BackupAndUploadTask
			
			this.databaseFolderNameField.setText(backupAndUploadTaskPr.getDropBoxFolderName());
			this.dropBoxClearField.setText(backupAndUploadTaskPr.getDropBoxClear()!=null ? backupAndUploadTaskPr.getDropBoxClear().toString() : "");
			this.databaseTypeField.setText(backupAndUploadTaskPr.getDatabaseType()!=null ? backupAndUploadTaskPr.getDatabaseType() : "");
			
			
			this.sqlConnectionField.setText(backupAndUploadTaskPr.getSqlConnectionString()!=null ? backupAndUploadTaskPr.getSqlConnectionString() : "");
			this.sqlDatabaseField.setText(backupAndUploadTaskPr.getSqlDatabaseName()!=null ? backupAndUploadTaskPr.getSqlDatabaseName() : "");
			this.backupsFolderField.setText(backupAndUploadTaskPr.getBackupsFolder()!=null ? backupAndUploadTaskPr.getBackupsFolder() : "");

			//.setText(backupAndUploadTaskPr.getBackupsFolder()()!=null ? backupAndUploadTaskPr.getBackupsFolder() : "");

			this.clearDayField.setText(backupAndUploadTaskPr.getClearBackupsFolder() != null ? backupAndUploadTaskPr.getClearBackupsFolder().toString() : "");
			
			this.nameField.setText(backupAndUploadTaskPr.getName());
			this.taskActiveField.setText(backupAndUploadTaskPr.isTaskActive() ? "true": "false");
			this.taskStartField.setText(backupAndUploadTaskPr.getTaskStart());
			this.taskEndField.setText(backupAndUploadTaskPr.getTaskEnd());
			this.taskRepeatField.setText(backupAndUploadTaskPr.getTaskRepeat() != -1 ? uploadFolderTaskPrivate.getTaskRepeat().toString() : "");
			
			
			
		}
	//System.out.println("iz objekta backups and upload*******************+" + backupAndUploadTaskPr.getName() );

	}
	
	
	//automaski generira mozda obrisat
	public EditTask(JTextField databaseFolderNameField, JTextField dropBoxClearField, JTextField folderPathField,
			JTextField nameField, JTextField taskActiveField, JTextField taskStartField, JTextField taskEndField,
			JTextField taskRepeatField, JTextField databaseTypeField, JTextField sqlConnectionField,
			JTextField sqlDatabaseField, JTextField backupsFolderField, JTextField clearDayField) {
		super();
		this.databaseFolderNameField = databaseFolderNameField;;
		this.dropBoxClearField = dropBoxClearField;
		this.folderPathField = folderPathField;
		this.nameField = nameField;
		this.taskActiveField = taskActiveField;
		this.taskStartField = taskStartField;
		this.taskEndField = taskEndField;
		this.taskRepeatField = taskRepeatField;
		this.databaseTypeField = databaseTypeField;
		this.sqlConnectionField = sqlConnectionField;
		this.sqlDatabaseField = sqlDatabaseField;
		this.backupsFolderField = backupsFolderField;
		this.clearDayField = clearDayField;
		
	
	}
	
	public EditTask() {
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
			nameField.setBounds(186, 31, 86, 20);
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
//					String forEmpty ="";
//					String clearDay =  clearDayField.getText();
//					
//					String taskNameToAdd = comboBox.getSelectedItem().toString();
//					
//				//	String taskNameToAdd = nameField.getText();
//					
//					String[] arrayUploadFolderTaskValues = {databaseFolderNameField.getText(),dropBoxClearField.getText(),folderPathField.getText(),
//							nameField.getText(),taskActiveField.getText(),taskStartField.getText(),taskEndField.getText(),
//							taskRepeatField.getText(),"valuezadji"};
//					
//					String[] arrayBackupAndUploadValues = {databaseFolderNameField.getText(),dropBoxClearField.getText(),
//							databaseTypeField.getText(),sqlConnectionField.getText(),sqlDatabaseField.getText(),
//							backupsFolderField.getText(),backupsFolderField.getText(),backupsFolderField.getText(),
//							forEmpty,forEmpty,clearDay,clearDay,clearDay,clearDay,clearDay,nameField.getText(),taskActiveField.getText(),
//							taskStartField.getText(),taskEndField.getText(),
//							taskRepeatField.getText(),"valuezadji"};
//					
//					for(int i=0;i<21;i++)
//					System.out.println(i+"."+ arrayBackupAndUploadValues[i] + ",");
					
					
					
//					if(taskNameToAdd.equals("BackupAndUploadTask") )
//						writingToOriginDocument(arrayBackupAndUploadValues,taskNameToAdd);
//					else
//						writingToOriginDocument(arrayUploadFolderTaskValues,taskNameToAdd);
					
				}
			});
			btnSubmit.setBounds(285, 30, 89, 23);
			getContentPane().add(btnSubmit);
		}
		
		JLabel lblFolderpath = new JLabel("FolderPath");
		lblFolderpath.setBounds(21, 160, 74, 20);
		getContentPane().add(lblFolderpath);
		
		JLabel lblName = new JLabel("New Task Name");
		lblName.setBounds(86, 34, 90, 14);
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
//		{
//			String[] comboOption= {"BackupAndUploadTask","UploadFolderTask"};
//			comboBox = new JComboBox(comboOption);
//			comboBox.setBounds(21, 31, 63, 20);
//			getContentPane().add(comboBox);
//		}
	}
	
	
	private static UploadFolderTask getSelectedTaskObjectForm(String selectedTask,String xmlPath,Integer selectedRow) { // za uploadFolderTask ----
	
		
		UploadFolderTask uploadFolderTask = new UploadFolderTask();
		
				
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
	        NodeList nodeList = doc.getElementsByTagName(selectedTask); // proslijediti u ovisnosti koji se hvataju BackupAndUpload ili
	        
	        
	        System.out.println(nodeList.getLength());
	        
	        	
	        	Node node = nodeList.item(selectedRow); ///ovdje treba poslati na koji se klinulo item --------i ovaj nod zamjenit
	        	
	        	
	        	System.out.println("????????????-----"+ nodeList.getLength() + "???-------------");
	        	
	        //	ispod petlje mozemo dodati nod i zmajenit ga ili ga uhvati priej da je drugo
	        	
	        	Element elementSubMain = (Element) node;
	        	
	        	
	        	//getting tasks to nodelist
	        	NodeList childNodeList = node.getChildNodes(); 
	        	
	        
	        	
	        	System.out.println("----------------------------------Datum pocetni" );
	        	for(int j=0;j<childNodeList.getLength();j++) {
	        		
	        		Node childNode = childNodeList.item(j); //hvatanje taskova(backup ili upload--u ovisnosti )
	         	
	        		
	        		NodeList arrayOfTasksElement = childNode.getChildNodes(); // hvatanja u listu nodova svih elemenata taska
	        		
	        		Element childElement = (Element) childNode;
	        		
	        		
	        		//childElement.getNodeName().equals("TaskStart");
	        		
	        			
	        		
	        		String childNodeName = childElement.getNodeName();
	        		
	        		String atributes = childElement.getAttribute("value"); // atributes for catching
	        		
	        		if(childElement.getNodeName().equals("DropBoxFolderName")) {
	        			uploadFolderTask.setDropBoxFolderName(atributes);
	        		}
	        		
	        		if(childElement.getNodeName().equals("DropBoxClear")) {
	        			if(atributes!="")
	        				uploadFolderTask.setDropBoxClear((Integer) Integer.parseInt(atributes!=null ? atributes: "0"));//jos nije sig
	        		}
	        		if(childElement.getNodeName().equals("FolderPath")) {
	        			uploadFolderTask.setFolderPath(atributes);
	        		}
	        		if(childElement.getNodeName().equals("Name")) {
	        			uploadFolderTask.setName(atributes);
	        		}
	        		if(childElement.getNodeName().equals("TaskActive")) {
	        			uploadFolderTask.setTaskActive(atributes.equals("true"));
	        		}
	        		if(childElement.getNodeName().equals("TaskStart")) {
	        			uploadFolderTask.setTaskStart(atributes);
	        		}
	        		
	        		if(childElement.getNodeName().equals("TaskEnd")) {
	        			uploadFolderTask.setTaskEnd(atributes);
	        		}
	        		
	        		if(childElement.getNodeName().equals("TaskRepeat")) {
	        			
	        			if(atributes != "")
	        				uploadFolderTask.setTaskRepeat(Integer.parseInt(atributes,10));
	        			else
	        				uploadFolderTask.setTaskRepeat(-1);  // mozda jos popravit
	        			
	        		}
	        		//mozda ce treba i za TaskLast
	        		
	        	
	        		System.out.println(j  +". podnodName:   "+"atribut:  " + atributes + "  " + childNodeName); //podNod je ustvari podchild(fieldov Taska)
	        	
	        	}
	        	//dataTable[i][0]= i+1; // hvatanje rowa
	        	
			//	System.out.println("iz objekta backups and upload" +  );

	        	System.out.println("----------------------------------");
	        	System.out.println("atribut name selectovanog " + uploadFolderTask.getName());
	        	
	        	Element element = (Element) node;
	        	
	        	//String atributes = element.getAttribute("value");
	        	
	        	
	        	
		        System.out.println("child nodes "  + ". "+node.getNodeName() +"duzina child noda" + childNodeList.getLength());
		        
		        
	      return uploadFolderTask;
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	  return null;
	}
	
	
	
	
private static BackupAndUploadTask getSelectedTaskObjectFormDrugiTip(String selectedTask,String xmlPath,Integer selectedRow) {
	
		
		BackupAndUploadTask backupAndUploadTask = new BackupAndUploadTask();
		
		
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
	      
	        	
	        	Node node = nodeList.item(selectedRow); ///ovdje treba poslati na koji se klinulo item --------i ovaj nod zamjenit
	        	
	        	
	        	System.out.println("????????????-----"+ nodeList.getLength() + "???-------------");
	        //	ispod petlje mozemo dodati nod i zmajenit ga ili ga uhvati priej da je drugo
	        	
	        	Element elementSubMain = (Element) node;
	        	
	        	
	        	//getting tasks to nodelist
	        	NodeList childNodeList = node.getChildNodes(); // catching field od Tasks
	        	
	        
	        	
	        	System.out.println("----------------------------------Datum pocetni" );
	        	for(int j=0;j<childNodeList.getLength();j++) {
	        		
	        		Node childNode = childNodeList.item(j); //hvatanje taskova(backup ili upload--u ovisnosti )
	         	
	        		
	        		NodeList arrayOfTasksElement = childNode.getChildNodes(); // hvatanja u listu nodova svih elemenata taska
	        		
	        		Element childElement = (Element) childNode;
	        		
	        		String childNodeName = childElement.getNodeName();
	        		
	        		String atributes = childElement.getAttribute("value"); // atributes for catching
	        		
	        		if(childNodeName.equals("DropBoxFolderName")) {
	        			backupAndUploadTask.setDropBoxFolderName(atributes);
	        		}
	        		
	        		if(childNodeName.equals("DropBoxClear")) {
	        			backupAndUploadTask.setDropBoxClear((Integer) Integer.parseInt(atributes!="" ? atributes: "0"));//jos nije sig
	        		}
	   
	        		if(childNodeName.equals("DatabaseType")) {
	
	        			backupAndUploadTask.setDatabaseType(atributes);
	        		}
	        		if(childNodeName.equals("SqlConnectionString")) {
	        			backupAndUploadTask.setSqlConnectionString(atributes);
	        		}
	        		
	        		if(childNodeName.equals("SqlDatabaseName")) {
	        			backupAndUploadTask.setSqlDatabaseName(atributes);
	        		}
	        		
	        		if(childNodeName.equals("BackupFolder")) { // izmjenit kasnijeee 
	        			backupAndUploadTask.setBackupsFolder(atributes);
	        		}

	        		if(childNodeName.equals("ClearBackupsFolder")) { //mozda iostali clear trebaju
	        			
	        			backupAndUploadTask.setClearBackupsFolder(atributes!="" ? Integer.parseInt(atributes,10) : -1);
	        		}
	        		
	        		if(childNodeName.equals("ClearRemoteFolder")) { //mozda iostali clear trebaju
	        			
	        			backupAndUploadTask.setClearBackupsFolder(atributes!="" ? Integer.parseInt(atributes,10) : -1);
	        		}
	        		
	        		if(childNodeName.equals("ClearLocalFolder")) { //mozda iostali clear trebaju
	        			
	        			backupAndUploadTask.setClearBackupsFolder(atributes!="" ? Integer.parseInt(atributes,10) : -1);
	        		}
	        		
	        		if(childNodeName.equals("ClearBackupFolder1")) { //mozda iostali clear trebaju
	        			
	        			backupAndUploadTask.setClearBackupsFolder(atributes!="" ? Integer.parseInt(atributes,10) : -1);
	        		}
	        		
	        		if(childNodeName.equals("ClearBackupFolder2")) { //mozda iostali clear trebaju
	        			
	        			backupAndUploadTask.setClearBackupsFolder(atributes!="" ? Integer.parseInt(atributes,10) : -1);
	        		}
	        	
	        		if(childNodeName.equals("Name")) {
	        			backupAndUploadTask.setName(atributes);
	        		}
	        		
	        		if(childNodeName.equals("TaskActive")) {
	        			backupAndUploadTask.setTaskActive(atributes.equals("true"));
	        		}
	        		if(childNodeName.equals("TaskStart")) {
	        			backupAndUploadTask.setTaskStart(atributes);
	        		}
	        		
	        		if(childNodeName.equals("TaskEnd")) {
	        			backupAndUploadTask.setTaskEnd(atributes);
	        		}
	        		
	        		if(childElement.getNodeName().equals("TaskRepeat")) {
	        			
	        			if(atributes != "")
	        				backupAndUploadTask.setTaskRepeat(Integer.parseInt(atributes,10));
	        			else
	        				backupAndUploadTask.setTaskRepeat(-1);  // mozda jos popravit
	        			
	        		}
	        		//mozda ce treba i za TaskLast
	        		
	        	
	        		System.out.println(j  +". podnodName:   "+"atribut:  " + atributes + "  " + childNodeName); //podNod je ustvari podchild(fieldov Taska)
	        	
	        	}
	        	//dataTable[i][0]= i+1; // hvatanje rowa
	        	
	        	
	        	System.out.println("----------------------------------");
	        	System.out.println("atribut name selectovanog " + backupAndUploadTask.getName());
	        	
	        	Element element = (Element) node;
	        	
	        	//String atributes = element.getAttribute("value");
	        	
	        	
	        	
		        System.out.println("child nodes "  + ". "+node.getNodeName() +"duzina child noda" + childNodeList.getLength());
		        
		        
	      return backupAndUploadTask;
	    }
	    catch (Exception e)
	    {
	        e.printStackTrace();
	    }
	  return null;
	}
		

		
		
private static UploadFolderTask setValueToUploadFolderTask(String atributes,Element childElement) {
		
	UploadFolderTask uploadFolderTask = new UploadFolderTask();
		
		
		return null;// trenutno
		
	
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

private static void replaceNode(String selectedTask, Integer selectedRow, String[] valueForReplace,String[] uploadNames) {
	
	
	String xmlPath = "C:\\nvbackupService\\TasksConfig.xml";
	
    
		   
				try {
					
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder;
					try {
						builder = factory.newDocumentBuilder();
						
						Document doc = builder.parse(new File(xmlPath));
						
						NodeList nodeList = doc.getElementsByTagName(selectedTask);
						
						Node node = nodeList.item(selectedRow);
						
				
						//node.getParentNode().replaceChild(newChild, node); for replacing
						
					    Element nodeForReplace = doc.createElement(selectedTask);
					    	for(int i=0; i < valueForReplace.length; i++) {
					    		
					    		Element newElement = doc.createElement(uploadNames[i]);
					    		newElement.setAttribute("value", valueForReplace[i]);
					    		nodeForReplace.appendChild(newElement);
					    	}
					    
					    	node.getParentNode().replaceChild(nodeForReplace, node);  //for replacing
					    	
					    	writtingToFile(doc);
							System.out.println("succesf");
					} catch (ParserConfigurationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        
		        
		      
	
}



//vjerovatno nece trebat
private  Node getNodeForReplace() {
	return nodeForReplace;
}




	
}
