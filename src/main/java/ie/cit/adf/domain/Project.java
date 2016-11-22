package ie.cit.adf.domain;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.CascadeType;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;
	private byte[] picture;
	private double goalAmount;
	
	@ManyToMany(fetch=FetchType.EAGER, mappedBy="projects_owned", cascade=CascadeType.ALL)
	private List<User> owners;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
	private List<Pledge> pledges;
	
	public Project() {
		super();
	}

	public Project(int id, String name, String description, byte[] picture, double goalAmount, List<User> owners,
			List<Pledge> pledges) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.picture = picture;
		this.goalAmount = goalAmount;
		this.owners = owners;
		this.pledges = pledges;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Project [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", picture=");
		builder.append(picture);
		builder.append(", goalAmount=");
		builder.append(goalAmount);
		builder.append(", owners=");
		builder.append(owners);
		builder.append(", pledges=");
		builder.append(pledges);
		builder.append("]");
		return builder.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	public double getGoalAmount() {
		return goalAmount;
	}

	public void setGoalAmount(double goalAmount) {
		this.goalAmount = goalAmount;
	}

	public List<User> getOwners() {
		return owners;
	}

	public void setOwners(List<User> owners) {
		this.owners = owners;
	}

	public List<Pledge> getPledges() {
		return pledges;
	}

	public void setPledges(List<Pledge> pledges) {
		this.pledges = pledges;
	}

}
