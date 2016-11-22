package ie.cit.adf.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
	private Collection<Project> projects;
	
	private String name;
	private String description;
	private char[] picture;
	
	public Category(int id, Collection<Project> projects, String name, String description, char[] picture) {
		super();
		this.id = id;
		this.projects = projects;
		this.name = name;
		this.description = description;
		this.picture = picture;
	}

	public Category() {
		super();
	}

	public int getId() {
		return id;
	}

	public Collection<Project> getProjects() {
		return projects;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public char[] getPicture() {
		return picture;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPicture(char[] picture) {
		this.picture = picture;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [id=");
		builder.append(id);
		builder.append(", projects=");
		builder.append(projects);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", picture=");
		builder.append(Arrays.toString(picture));
		builder.append("]");
		return builder.toString();
	}
}
