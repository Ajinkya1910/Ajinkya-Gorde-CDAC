import finance.*;

class EarlyBindTest{

	public static void main(String[] args) throws Exception{
		double p = Double.parseDouble(args[0]);
		Class<?> c = args.length > 1 ? Class.forName(args[1]) : PersonalLoan.class;
		LoanPolicy pol = (LoanPolicy)c.getDeclaredConstructor().newInstance();
		int m = 10;
		for(int n = 1; n <= m; ++n){
			float r = pol.interestRate(p, n);
			float i = r / 1200;
			double emi = p * i / (1 - Math.pow(1 + i, -12 * n));
			System.out.printf("%d\t%.2f%n", n, emi);
		}
	}
}


