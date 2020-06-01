package main.java;

public class Goal 
{
	public enum Status
	{
		NOT_STARTED, 
		IN_PROGRESS, 
		MET
	}
	
	private Integer id;
	private Integer ownerId;
	private String title;
	private String description;
	private Status status;
	private String goalType;

	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer anId)
	{
		id = anId;
	}
	
	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getGoalType() {
		return goalType;
	}

	public void setGoalType(String goalType) {
		this.goalType = goalType;
	}
	
}
