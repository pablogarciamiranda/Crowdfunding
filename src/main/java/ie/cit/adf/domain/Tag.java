package ie.cit.adf.domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity(name="Tags")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToMany(mappedBy="tags", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private Collection<Project> projects;
	
	private String name;

	public Tag(int id, Collection<Project> projects, String name) {
		super();
		this.id = id;
		this.projects = projects;
		this.name = name;
	}

	public Tag() {
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

	public void setId(int id) {
		this.id = id;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tag [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
}
