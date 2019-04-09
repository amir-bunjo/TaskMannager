package task.classes;

public class UploadFolderTask {
	
	private Integer id;
	
	private String dropBoxFolderName ;
	
	private Integer dropBoxClear;

	private String folderPath ;
	
	private String name;

	private boolean taskActive;
	
	private String taskStart;	
	
	private String taskEnd;

	private Integer taskRepeat ;

	private Float taskLast;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getFolderPath() {
		return folderPath;
	}

	public void setFolderPath(String folderPath) {
		this.folderPath = folderPath;
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
