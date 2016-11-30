package ie.cit.adf;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ie.cit.adf.CrowdFundingApplication;
import ie.cit.adf.domain.Category;
import ie.cit.adf.domain.Pledge;
import ie.cit.adf.domain.Project;
import ie.cit.adf.domain.Reward;
import ie.cit.adf.domain.Tag;
import ie.cit.adf.domain.User;
import ie.cit.adf.repositories.CategoryRepository;
import ie.cit.adf.repositories.PledgeRepository;
import ie.cit.adf.repositories.ProjectRepository;
import ie.cit.adf.repositories.RewardRepository;
import ie.cit.adf.repositories.TagRepository;
import ie.cit.adf.repositories.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrowdFundingApplication.class)
@WebAppConfiguration
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class CrowdFundingApplicationTest {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PledgeRepository pledgeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	@Autowired
	private RewardRepository rewardRepository;

	@Test
	public void showAllProjects() {
		List<Project> projects = (List<Project>) projectRepository.findAll();
		for (Project project : projects){
			System.out.println(project.toString());
					
			List<Tag> tags = (List<Tag>) project.getTags();
			System.out.println("Tags:");
			for (Tag tag : tags){
				System.out.print(tag.toString());
			}
			
			List<User> owners = (List<User>) project.getOwners();
			System.out.println("\nOwners:");
			for (User user : owners){
				System.out.print(user.toString());
			}
		}
	}

	@Test
	public void showAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		for (User user : users){
			System.out.println(user.toString());
			
			List<Project> projects = (List<Project>) user.getProjects_owned();
			System.out.println("Projects:");
			for (Project project : projects){
				System.out.print(project.toString());
			}
			
			List<Pledge> pledges = (List<Pledge>) user.getPledges();
			System.out.println("\nPledges:");
			for (Pledge pledge : pledges){
				System.out.print(pledge.toString());
			}
		}
	}
	
	@Test
	public void showAllPledges() {
		List<Pledge> pledges = (List<Pledge>) pledgeRepository.findAll();
		System.out.println("Pledges: ");
		for (Pledge pledge : pledges){
			System.out.println(pledge.toString());
		}
	}
	
	@Test
	public void showAllCategories(){
		List<Category> categories = (List<Category>) categoryRepository.findAll();
		for (Category category : categories){
			System.out.println(category.toString());
					
			List<Project> projects = (List<Project>) category.getProjects();
			System.out.println("Projects:");
			for (Project project : projects){
				System.out.print(project.toString());
			}
		}
	}
	
	@Test
	public void showAllTags(){
		List<Tag> tags = (List<Tag>) tagRepository.findAll();
		for (Tag tag : tags){
			System.out.println(tag.toString());
					
			List<Project> projects = (List<Project>) tag.getProjects();
			System.out.println("Projects:");
			for (Project project : projects){
				System.out.print(project.toString());
			}
		}
	}
	
	@Test
	public void showAllRewards() {
		List<Reward> rewards = (List<Reward>) rewardRepository.findAll();
		System.out.println("Rewards: ");
		for (Reward reward : rewards){
			System.out.println(reward.toString());
		}
	}
	
}
