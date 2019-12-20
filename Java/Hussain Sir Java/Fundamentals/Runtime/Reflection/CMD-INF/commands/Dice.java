package commands;

public class Dice{

	public static void execute(String arg){
		java.util.Random rnd = new java.util.Random();
		int n = 1 + rnd.nextInt(6);
		System.out.printf("Value = %d%n", n);
	}
}
