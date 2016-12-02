package ie.cit.adf.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="Pledges")
public class Pledge {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="id_reward")
	private Reward reward;
	
	public Pledge(int id, User user, Reward reward) {
		super();
		this.id = id;
		this.user = user;
		this.reward = reward;
	}

	public Pledge() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pledge [id=");
		builder.append(id);
		builder.append(", user=");
		builder.append(user.getName());
		builder.append(", reward=");
		builder.append(reward.getName());
		builder.append("]");
		return builder.toString();
	}

}
