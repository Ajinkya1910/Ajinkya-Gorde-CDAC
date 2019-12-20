package finance;

@MaxDuration(value=4)
public class PersonalLoan implements LoanPolicy{

	public float interestRate(double p, int n){
		return (p <= 50000) ? 10.5f : 11.5f;
	}

	public float interestRateForEmployees(double p, int n){
		return (p <= 100000) ? 5.0f : 5.5f;
	}
}












