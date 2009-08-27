package it.uniba.di.cdg.econference.planningpoker.model.backlog;



public class DefaultUserStory implements IUserStory {
	
	public enum PRIORITY { UNKNOWN("Unknow"), HIGH("High"), MEDIUM("Medium"), 
		LOW("Low");
	
	private String name;
	
	private PRIORITY(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	} };

	private String name;
	private PRIORITY priority;
	private String 	description;
	private Object points;
	
	public DefaultUserStory(String name, PRIORITY priority, String description,
			Object points) {
		this.name = name;
		this.priority = priority;
		this.description = description;
		this.points = points;		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PRIORITY getPriority() {
		return priority;
	}
	public void setPriority(PRIORITY priority) {
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public void setEstimate(Object points) {
		this.points = points;		
	}
	@Override
	public Object getEstimate() {
		return points;
	}
	@Override
	public String getTextForMultiChatSubject() {
		return getName();
	}

}