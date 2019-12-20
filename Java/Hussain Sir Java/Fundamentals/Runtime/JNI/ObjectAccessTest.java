class LegacyTaxPayer{

	private double income;

	public LegacyTaxPayer(double income){
		this.income = income;
	}

	public boolean validate(short age){
		return age >= 16 && age <= 100;
	}

	public native double getIncomeTax(short age);

	static{
		System.loadLibrary("ltaxp");
	}
}

class ObjectAccessTest{

	public static void main(String[] args){
		double i = Double.parseDouble(args[0]);
		short a = Short.parseShort(args[1]);
		LegacyTaxPayer emp = new LegacyTaxPayer(i);
		try{
			System.out.printf("Income Tax: %.2f%n", emp.getIncomeTax(a));
		}catch(Exception e){
			System.out.println(e);
		}
	}
}


