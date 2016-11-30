package ie.cit.adf.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.Date;

@Entity(name="Rewards")
public class Reward {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_project")
	private Project project;
	
	private String name;
	private double amount;
	private String description;
	
	@Column(name="estimateddelivery")
	private Date estimatedDelivery;
	@Column(name="limitavailability")
	private boolean limitAvailability;
	
	public Reward(int id, Project project, String name, double amount, String description, Date estimatedDelivery,
			boolean limitAvailability) {
		super();
		this.id = id;
		this.project = project;
		this.name = name;
		this.amount = amount;
		this.description = description;
		this.estimatedDelivery = estimatedDelivery;
		this.limitAvailability = limitAvailability;
	}

	public Reward() {
		super();
	}

	public int getId() {
		return id;
	}

	public Project getProject() {
		return project;
	}

	public String getName() {
		return name;
	}

	public double getAmount() {
		return amount;
	}

	public String getDescription() {
		return description;
	}

	public Date getEstimatedDelivery() {
		return estimatedDelivery;
	}

	public boolean isLimitAvailability() {
		return limitAvailability;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setEstimatedDelivery(Date estimatedDelivery) {
		this.estimatedDelivery = estimatedDelivery;
	}

	public void setLimitAvailability(boolean limitAvailability) {
		this.limitAvailability = limitAvailability;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reward [id=");
		builder.append(id);
		builder.append(", project=");
		builder.append(project);
		builder.append(", name=");
		builder.append(name);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", description=");
		builder.append(description);
		builder.append(", estimatedDelivery=");
		builder.append(estimatedDelivery);
		builder.append(", limitAvailability=");
		builder.append(limitAvailability);
		builder.append("]");
		return builder.toString();
	}
	
}
