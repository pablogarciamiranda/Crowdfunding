package ie.cit.adf.repositories;

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
import ie.cit.adf.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CrowdFundingApplication.class)
@WebAppConfiguration
@DirtiesContext(classMode=ClassMode.AFTER_EACH_TEST_METHOD)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void contextLoads() {
		List<User> users = (List<User>) userRepository.findAll();
		for (User user : users){
			System.out.println(user.toString());
		}
	}

}
