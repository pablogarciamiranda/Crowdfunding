package ie.cit.adf.validation;

import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import ie.cit.adf.domain.Category;

public class ProjectForm {
	
	@NotBlank
    @Length(min = 4)
	private String name;
	
	@NotNull
	private Category category;
	
	@NotBlank
    @Length(min = 4)
	private String location;
	
	@NotBlank
    @Length(min = 4, max = 140)
	private String description;
	
	@NotNull
	@Min(1)
	@Max(7)
	private BigDecimal fundingAmount;
	
	@NotNull
	@Min(1)
	@Max(4)
	private Integer numberOfDays;
	
	
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
	
	public BigDecimal getFundingAmount() {
		return fundingAmount;
	}
	
	public void setFundingAmount(BigDecimal fundingAmount) {
		this.fundingAmount = fundingAmount;
	}
	
	public int getNumberOfDays() {
		return numberOfDays;
	}
	
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
