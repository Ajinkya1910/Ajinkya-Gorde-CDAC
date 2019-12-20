package commands;

public class Greet{
	
	public static void execute(String arg){
		System.out.printf("Greetings %s!%n", System.getProperty("user.name"));
	}
}

