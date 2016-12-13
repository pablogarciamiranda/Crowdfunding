package ie.cit.adf.services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import ie.cit.adf.domain.Project;

@RunWith(MockitoJUnitRunner.class)
public class ProjectServiceTester {

	private ProjectService projectService;
	
	@Before
	public void setUp(){
		projectService = mock(ProjectService.class);
	}
	
	@Test
	public void testProjectService(){

		Project p = new Project();
		p.setName("This is a test name");
		p.setCurrentAmount(123456);
		p.setFundingAmount(456789);
		p.setDescription("Lorem ipsum and all that stuff people like to write around");
		p.setLocation("The middle of nowhere");
		p.setNumberOfDays(99);
		
		projectService.addProject(p);
		
		ArrayList<Project> result = new ArrayList<Project>();
		result.add(p);
		
		when(projectService.findAll()).thenReturn((Collection<Project>)result);

	    Assert.assertEquals(projectService.findAll(),(Collection<Project>)result);
	}
}
