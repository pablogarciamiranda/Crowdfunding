package ie.cit.adf;

import java.io.PrintStream;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import ie.cit.adf.services.ProjectServiceTester;
import ie.cit.adf.services.UserServiceTester;

public class TestRunner {
	
	private static PrintStream out = System.out;

	public static void main(String[] args) {
		runTesterClass(ProjectServiceTester.class);
		runTesterClass(UserServiceTester.class);
	}
	
	private static void runTesterClass(@SuppressWarnings("rawtypes") Class c){
		out.println("Testing " + c.getName() + ":");
	    Result result = JUnitCore.runClasses(c);
	      
	    for (Failure failure : result.getFailures()) {
	       out.println(failure.toString());
	    }
	      
	    out.println("Was successful: " + result.wasSuccessful() + "\n");
	}
	
}
