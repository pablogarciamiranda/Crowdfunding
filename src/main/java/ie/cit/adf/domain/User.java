package ie.cit.adf.domain;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;


@Entity(name="Users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToMany(mappedBy="owners", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Collection<Project> projects_owned;
	
	@OneToMany(mappedBy = "user", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Collection<Pledge> pledges;
	
	@NotEmpty
	private String username;
	@NotEmpty
	private char[] password;
	
	private String name;
	private String location;
	private String biography;
	@NotEmpty
	private String email;
	@Column(name="creditlimit")
	private double creditLimit;
	private boolean enabled;

	public User(int id, String username, char[] password, String name, String location, String biography, String email,
			double creditLimit, Collection<Project> projects_owned, Collection<Pledge> pledges, Boolean enabled) {
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
		this.enabled = enabled;
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
	
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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
		builder.append("]");
		return builder.toString();
	}
	
}