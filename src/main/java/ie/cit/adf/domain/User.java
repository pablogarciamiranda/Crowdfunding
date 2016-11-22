package ie.cit.adf.domain;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.UniqueConstraint;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private char[] password;
	private double creditLimit;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="users_projects", 
			uniqueConstraints = {
	            	@UniqueConstraint(name = "user_project_unique", columnNames = {"user_id", "project_id"})
	        },
			joinColumns = {
				 	@JoinColumn(name="user_id", referencedColumnName="id")
			},
			inverseJoinColumns = {
					@JoinColumn(name="project_id", referencedColumnName="id")
					}
	)
	private List<Project> projects_owned;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private List<Pledge> pledges;
	
	public User(int userId, String name, char[] password, double creditLimit, List<Project> projects_owned,
			List<Pledge> pledges) {
		super();
		this.id = userId;
		this.name = name;
		this.password = password;
		this.creditLimit = creditLimit;
		this.projects_owned = projects_owned;
		this.pledges = pledges;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", password=");
		builder.append(Arrays.toString(password));
		builder.append(", creditLimit=");
		builder.append(creditLimit);
		builder.append(", projects_owned=");
		builder.append(projects_owned);
		builder.append(", pledges=");
		builder.append(pledges);
		builder.append("]");
		return builder.toString();
	}

	public User() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public List<Project> getProjects_owned() {
		return projects_owned;
	}

	public void setProjects_owned(List<Project> projects_owned) {
		this.projects_owned = projects_owned;
	}

	public List<Pledge> getPledges() {
		return pledges;
	}

	public void setPledges(List<Pledge> pledges) {
		this.pledges = pledges;
	}

}
