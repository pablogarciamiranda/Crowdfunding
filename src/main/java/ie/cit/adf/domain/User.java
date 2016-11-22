package ie.cit.adf.domain;
import java.util.Arrays;
import java.util.Collection;
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
	private Collection<Project> projects_owned;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
	private Collection<Pledge> pledges;
	
	private String username;
	private char[] password;
	
	private String name;
	private String location;
	private String biography;
	private String email;
	private double creditLimit;

	public User(int id, String username, char[] password, String name, String location, String biography, String email,
			double creditLimit, Collection<Project> projects_owned, Collection<Pledge> pledges) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.location = location;
		this.biography = biography;
		this.email = email;
		this.creditLimit = creditLimit;
		this.projects_owned = projects_owned;
		this.pledges = pledges;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Collection<Project> getProjects_owned() {
		return projects_owned;
	}

	public void setProjects_owned(List<Project> projects_owned) {
		this.projects_owned = projects_owned;
	}

	public Collection<Pledge> getPledges() {
		return pledges;
	}

	public void setPledges(List<Pledge> pledges) {
		this.pledges = pledges;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(Arrays.toString(password));
		builder.append(", name=");
		builder.append(name);
		builder.append(", location=");
		builder.append(location);
		builder.append(", biography=");
		builder.append(biography);
		builder.append(", email=");
		builder.append(email);
		builder.append(", creditLimit=");
		builder.append(creditLimit);
		builder.append(", projects_owned=");
		builder.append(projects_owned);
		builder.append(", pledges=");
		builder.append(pledges);
		builder.append("]");
		return builder.toString();
	}
	
}
