package finance;

@MaxDuration(12)
public class HomeLoan implements LoanPolicy{

	public float interestRate(double p, int n){
		return (n <= 5) ? 8.5f : 9.0f;
	}
}












