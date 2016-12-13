package ie.cit.adf.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ie.cit.adf.domain.User;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTester {
	
private UserService userService;
	
	@Before
	public void setUp(){
		userService = mock(UserService.class);
	}
	
	@Test
	public void testProjectService(){

		User u = new User();
		String username = "Caranchoa";
		u.setUsername(username);
		u.setPassword("pambisito".toCharArray());
		String name = "Tonto'l pueblo"; 
		u.setName(name);
		u.setLocation("Llevando una buena hostia bien ganada");
		u.setBiography("Como si yo tuviera de eso");
		String email = "cara@anchoa.plas";
		u.setEmail(email);
		u.setCreditLimit(1000);
		u.setEnabled(true);
		
		ArrayList<User> result = new ArrayList<User>();
		result.add(u);	
		
		when(userService.registerAccount(u)).thenReturn(u);		
		when(userService.nameExists(name)).thenReturn(true);
		when(userService.nameExists("Non-existing name")).thenReturn(false);
		when(userService.emailExists(email)).thenReturn(true);
		when(userService.emailExists("Non-existing email")).thenReturn(false);
		when(userService.getByUsername(username)).thenReturn(u);			
		when(userService.findAll()).thenReturn((Collection<User>)result);

		userService.deleteAccount(u);
			
		when(userService.nameExists(name)).thenReturn(false);
		when(userService.nameExists("Non-existing name")).thenReturn(false);
		when(userService.emailExists(email)).thenReturn(false);
		when(userService.emailExists("Non-existing email")).thenReturn(false);
		when(userService.getByUsername(username)).thenReturn(null);			
		when(userService.findAll()).thenReturn(null);
	}

}
