package finance;

public class BusinessLoan{
	
	public float rateOfInterest(double p, int n){
		float r = (p < 100000) ? 11.5f : 12.5f;
		if(n >= 3) r += 0.5f;
		return r;
	}
}


















