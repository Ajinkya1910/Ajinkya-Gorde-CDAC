package edu.met.banking;
//non-inheritable class
final class SavingsAccount extends Account implements Profitable{

	static final double MIN_BAL = 5000; //constant field

	SavingsAccount(){
		balance = MIN_BAL;
	}

	public void deposit(double amount){
		balance += amount;
	}

	public void withdraw(double amount) throws InsufficientFundsException{
		if(balance - amount < MIN_BAL)
			throw new InsufficientFundsException();
		balance -= amount;
	}

	public double interest(int months){
		float rate = balance < 5 * MIN_BAL ? 4 : 5;
		return balance * months * rate / 1200;
	}
}


