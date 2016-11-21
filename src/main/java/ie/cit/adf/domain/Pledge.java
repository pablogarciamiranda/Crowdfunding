package ie.cit.adf.domain;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Pledge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="project_id")
	private Project project;
	
	private int amount;
	
	public Pledge(int id, User user, Project project, int amount) {
		super();
		this.id = id;
		this.user = user;
		this.project = project;
		this.amount = amount;
	}

	public Pledge() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pledge [id=");
		builder.append(id);
		builder.append(", user=");
		builder.append(user);
		builder.append(", project=");
		builder.append(project);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}

	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
