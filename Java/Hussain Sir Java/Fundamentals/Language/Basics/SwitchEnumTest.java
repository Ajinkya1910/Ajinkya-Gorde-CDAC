enum RiskLevel{
	LOW,
	MEDIUM,
	HIGH;
}

class SwitchEnumTest{

	private static double getIncome(double invest, int period, RiskLevel risk){
		float rate;
		switch(risk){
			case LOW:
				rate = 5;
				break;
			case HIGH:
				rate = 8;
				break;
			default:
				rate = 7;
		}
		double amount = invest * Math.pow(1 + rate / 100, period);
		return amount - invest;
	}

	public static void main(String[] args){
		double p = Double.parseDouble(args[0]);
		int n = Integer.parseInt(args[1]);
		System.out.printf("Income in Bronze scheme: %.2f%n", getIncome(p, n, RiskLevel.LOW)); 
		System.out.printf("Income in Silver scheme: %.2f%n", getIncome(p, n, RiskLevel.MEDIUM)); 
		System.out.printf("Income in Gold scheme: %.2f%n", getIncome(p, n, RiskLevel.HIGH)); 
		//System.out.printf("Income in Diamond scheme: %.2f%n", getIncome(p, n, RiskLevel.HIGHEST)); 
	}
}

