package task.classes;

public class BackupAndUploadTask {
	
private String dropBoxFolderName;
	
	private Integer dropBoxClear;

	private String databaseType ;
	
	private String sqlConnectionString;
	
	private String sqlDatabaseName;

	private String backupsFolder;

	private String remoteFolder;

	private String localFolder;
	
	private String backupFolder1;

	private String backupFolder2;

	private Integer clearBackupsFolder;
	
	private Integer clearRemoteFolder;

	private Integer clearLocalFolder;
	
	private Integer clearBackupFolder1;

	private Integer clearBackupFolder2;
	
	private String name; //ime taska
	
	private boolean taskActive;
	
	private String taskStart;	
	
	private String taskEnd;

	private Integer taskRepeat ;

	private Float taskLast;

	public String getDropBoxFolderName() {
		return dropBoxFolderName;
	}

	public void setDropBoxFolderName(String dropBoxFolderName) {
		this.dropBoxFolderName = dropBoxFolderName;
	}

	public Integer getDropBoxClear() {
		return dropBoxClear;
	}

	public void setDropBoxClear(Integer dropBoxClear) {
		this.dropBoxClear = dropBoxClear;
	}

	public String getDatabaseType() {
		return databaseType;
	}

	public void setDatabaseType(String databaseType) {
		this.databaseType = databaseType;
	}

	public String getSqlConnectionString() {
		return sqlConnectionString;
	}

	public void setSqlConnectionString(String sqlConnectionString) {
		this.sqlConnectionString = sqlConnectionString;
	}

	public String getSqlDatabaseName() {
		return sqlDatabaseName;
	}

	public void setSqlDatabaseName(String sqlDatabaseName) {
		this.sqlDatabaseName = sqlDatabaseName;
	}

	public String getBackupsFolder() {
		return backupsFolder;
	}

	public void setBackupsFolder(String backupsFolder) {
		this.backupsFolder = backupsFolder;
	}

	public String getRemoteFolder() {
		return remoteFolder;
	}

	public void setRemoteFolder(String remoteFolder) {
		this.remoteFolder = remoteFolder;
	}

	public String getLocalFolder() {
		return localFolder;
	}

	public void setLocalFolder(String localFolder) {
		this.localFolder = localFolder;
	}

	public String getBackupFolder1() {
		return backupFolder1;
	}

	public void setBackupFolder1(String backupFolder1) {
		this.backupFolder1 = backupFolder1;
	}

	public String getBackupFolder2() {
		return backupFolder2;
	}
	
	
	public void setBackupFolder2(String backupFolder2) {
		this.backupFolder2 = backupFolder2;
	}

	public Integer getClearBackupsFolder() {
		return clearBackupsFolder;
	}

	public void setClearBackupsFolder(Integer clearBackupsFolder) {
		this.clearBackupsFolder = clearBackupsFolder;
	}

	public Integer getClearRemoteFolder() {
		return clearRemoteFolder;
	}

	public void setClearRemoteFolder(Integer clearRemoteFolder) {
		this.clearRemoteFolder = clearRemoteFolder;
	}

	public Integer getClearLocalFolder() {
		return clearLocalFolder;
	}

	public void setClearLocalFolder(Integer clearLocalFolder) {
		this.clearLocalFolder = clearLocalFolder;
	}

	public Integer getClearBackupFolder1() {
		return clearBackupFolder1;
	}

	public void setClearBackupFolder1(Integer clearBackupFolder1) {
		this.clearBackupFolder1 = clearBackupFolder1;
	}

	public Integer getClearBackupFolder2() {
		return clearBackupFolder2;
	}

	public void setClearBackupFolder2(Integer clearBackupFolder2) {
		this.clearBackupFolder2 = clearBackupFolder2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isTaskActive() {
		return taskActive;
	}

	public void setTaskActive(boolean taskActive) {
		this.taskActive = taskActive;
	}

	public String getTaskStart() {
		return taskStart;
	}

	public void setTaskStart(String taskStart) {
		this.taskStart = taskStart;
	}

	public String getTaskEnd() {
		return taskEnd;
	}

	public void setTaskEnd(String taskEnd) {
		this.taskEnd = taskEnd;
	}

	public Integer getTaskRepeat() {
		return taskRepeat;
	}

	public void setTaskRepeat(Integer taskRepeat) {
		this.taskRepeat = taskRepeat;
	}

	public Float getTaskLast() {
		return taskLast;
	}

	public void setTaskLast(Float taskLast) {
		this.taskLast = taskLast;
	}

}
