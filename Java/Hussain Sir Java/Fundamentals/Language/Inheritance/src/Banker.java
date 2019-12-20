package edu.met.banking;

public class Banker{

	private static long nid;

	private Banker(){}

	//static initializer (executes once when class is accessed for the first time)
	static{
		System.out.println("Welcome to banking.");
		nid = System.currentTimeMillis() % 1000000;
	}

	public static Account openCurrentAccount(){
		Account acc = new CurrentAccount();
		acc.id = 10000000 + nid++;
		return acc;
	}

	public static Account openSavingsAccount(){
		Account acc = new SavingsAccount();
		acc.id = 20000000 + nid++;
		return acc;
	}
}

