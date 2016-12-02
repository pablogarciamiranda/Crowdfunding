package ie.cit.adf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrowdFundingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrowdFundingApplication.class, args);
		System.out.println("This is a test sentence!");
	}
}
