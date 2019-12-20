class ThreadSyncTest{

	static class JointAccount{

		private int balance = 0;

		public int getBalance(){
			return balance;
		}

		public synchronized void deposit(int amount){
			Worker.doWork(amount / 1000);
			balance += amount;
		}

		public boolean withdraw(int amount){
			boolean result = false;
			synchronized(this){
				if(balance >= amount){
					Worker.doWork(amount / 1000);
					balance -= amount;
					result = true;
				}
			}
			return result;
		}
	}

	public static void main(String[] args) throws Exception{
		JointAccount acc = new JointAccount();
		acc.deposit(10000);
		System.out.println("Joint-account opened for Jack and Jill");
		System.out.printf("Initial balance: %d%n", acc.getBalance());
		System.out.println("Jack withdraws 6000 from joint-account...");
		Thread child = new Thread(() -> {
			if(acc.withdraw(6000) == false)
					System.out.println("Jack's withdraw operation failed!");
		});
		child.start();
		System.out.println("Jill withdraws 7000 from joint-account...");
		if(acc.withdraw(7000) == false)
			System.out.println("Jill's withdraw operation failed!");
		child.join();
		System.out.printf("Final balance: %d%n", acc.getBalance());
	}
}











