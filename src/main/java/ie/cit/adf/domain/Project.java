package ie.cit.adf.domain;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity(name="Projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name="projects_owners", 
			uniqueConstraints = {
	            	@UniqueConstraint(name = "project_user_unique", columnNames = {"id_project", "id_user"})
	        },
			joinColumns = {
				 	@JoinColumn(name="id_project", referencedColumnName="id")
			},
			inverseJoinColumns = {
					@JoinColumn(name="id_user", referencedColumnName="id")
					}
	)
	private Collection<User> owners;
	
	@OneToMany(mappedBy = "project")
	@Fetch(FetchMode.SELECT)
	private Collection<Reward> rewards;
	
	@ManyToOne
	@JoinColumn(name="id_category")
	private Category category;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	@JoinTable(name="projects_tags", 
			uniqueConstraints = {
	            	@UniqueConstraint(name = "project_tag_unique", columnNames = {"id_project", "id_tag"})
	        },
			joinColumns = {
				 	@JoinColumn(name="id_project", referencedColumnName="id")
			},
			inverseJoinColumns = {
					@JoinColumn(name="id_tag", referencedColumnName="id")
					}
	)
	private Collection<Tag> tags;

	private String name;
	private String location;
	private String description;
	private byte[] picture;
	
	private double currentAmount;
	@Column(name="fundingamount")
	private double fundingAmount;
	@Column(name="numberofdays")
	private int numberOfDays;
	
	public Project(int id, Collection<User> owners, Collection<Reward> rewards, Category category, Collection<Tag> tags, String name,
			String location, String description, byte[] picture, double currentAmount, double fundingAmount,
			int numberOfDays) {
		super();
		this.id = id;
		this.owners = owners;
		this.rewards = rewards;
		this.category = category;
		this.tags = tags;
		this.name = name;
		this.location = location;
		this.description = description;
		this.picture = picture;
		this.currentAmount = currentAmount;
		this.fundingAmount = fundingAmount;
		this.numberOfDays = numberOfDays;
	}

	public Project() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<User> getOwners() {
		return owners;
	}

	public void setOwners(List<User> owners) {
		this.owners = owners;
	}

	public Collection<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(List<Reward> rewards) {
		this.rewards = rewards;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
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

	public double getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(double currentAmount) {
		this.currentAmount = currentAmount;
	}

	public double getFundingAmount() {
		return fundingAmount;
	}

	public void setFundingAmount(double fundingAmount) {
		this.fundingAmount = fundingAmount;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Project [id=");
		builder.append(id);
//		builder.append(", category=");
//		builder.append(category.getName());
		builder.append("), name=");
		builder.append(name);
		builder.append(", location=");
		builder.append(location);
		builder.append(", description=");
		builder.append(description);
		builder.append(", picture=");
		builder.append(Arrays.toString(picture));
		builder.append(", currentAmount=");
		builder.append(currentAmount);
		builder.append(", fundingAmount=");
		builder.append(fundingAmount);
		builder.append(", numberOfDays=");
		builder.append(numberOfDays);
		builder.append("]");
		return builder.toString();
	}
	
}
