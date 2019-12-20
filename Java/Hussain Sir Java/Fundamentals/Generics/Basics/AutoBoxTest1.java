import java.util.Arrays;

class AutoBoxTest1{
	
	private static Double getBalance(String name){
		String[] names = {"jack", "jane", "jeff", "jill", "john"};
		double[] balances = {7000, 9000, 10000, 8000, 6000};
		//Arrays.sort(names);
		int i = Arrays.binarySearch(names, name);
		if(i >= 0)
			return balances[i]; //boxing - Double.valueOf(balance[i]) 
		return null;
	}
	
	public static void main(String[] args){
		Double result = getBalance(args[0]);
		if(result != null){
			double bal = result; //unboxung - result.doubleValue()
			System.out.printf("Balance: %.2f%n", bal);
		}else{
			System.out.printf("Cannot find %s%n", args[0]);
		}
	}
}

