package ie.cit.adf;

import java.io.PrintStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrowdFundingApplication {
	
	public static final int NUM_SYMBOLS = 65;
	public static final char SYMBOL = '*';

	private static PrintStream out = System.out;
	
	public static void main(String[] args) {
		SpringApplication.run(CrowdFundingApplication.class, args);
		out.println();
		printSymbols();
		out.print("CrowdFunding is running");
		printSymbols();
		out.println();
	}
	
	private static void printSymbols() {
		for(int i = 0; i < NUM_SYMBOLS; i++)
			out.print(SYMBOL);
	}
}
