import edu.met.banking.*;

class InterfaceTest1{

	private static void deductTax(Account[] accounts){
		for(Account acc : accounts){
			double extra = acc.getBalance() - 25000;
			if(extra > 0){
				try{
					acc.withdraw(0.05 * extra);
				}catch(InsufficientFundsException e){}
			}
		}
	}

	private static void payAnnualInterest(Account[] accounts){
		for(Account acc : accounts){
			if(acc instanceof Profitable){
				Profitable p = (Profitable)acc;
				double amount = p.interest(12);
				acc.deposit(amount);
			}
		}
	}

	public static void main(String[] args){
		Account[] bank = new Account[5];
		bank[0] = Banker.openSavingsAccount();
		bank[0].deposit(5000);
		bank[1] = Banker.openCurrentAccount();
		bank[1].deposit(20000);
		bank[2] = Banker.openSavingsAccount();
		bank[2].deposit(25000);
		bank[3] = Banker.openCurrentAccount();
		bank[3].deposit(40000);
		bank[4] = Banker.openSavingsAccount();
		bank[4].deposit(45000);
		deductTax(bank);
		payAnnualInterest(bank);
		for(Account acc : bank)
			System.out.printf("%d\t%.2f%n", acc.getId(), acc.getBalance());
	}

}


