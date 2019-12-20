using System;

namespace Banking
{
	public abstract class loan
	{
	
		public double principle {get; internal set;}
	
		public float period {get; internal set;}

		internal loan()
		{
			principle = 0;
			period = 0;
		}

		internal loan(double p, float n)
		{
			principle = p;
			period = n;
		}
	
			
		public abstract float GetRate();


		public float GetEMI()
	
		{

		float EMI = (float) principle * (1 + GetRate() * period / 100) / (12 * period);
		return EMI;

		}

	}

sealed class Personalloan :loan
{
		internal Personalloan() : base()
		{
			
		}


		internal Personalloan(double p, float n) : base(p, n)
		{
			
		}
  //For Personalloan (upto 5 lakhs  is 15% above 5 lakhs 16%)

	public override float GetRate()
	{
		float rate;
	       if (principle <= 500000)
		rate = 15;
		else
		rate = 16;
		return rate;	
	}
}

	
sealed class Homeloan :loan
	{

		internal Homeloan() : base()
		{
			
		}


		internal Homeloan(double p, float n) : base(p, n)
		{
			
		}
		public override float GetRate()
		{
			float rate;
       			if (principle <= 2000000)
			rate = 10/100;
			else
			rate = 11/100;
			return rate;	
		}
	}


public static class Applyloan
	{
		public static loan ApplyHomeloan(double p, float n)
			{
				var ln = new Homeloan(p, n);
				return ln;	  
			}
	
		public static loan ApplyPersonalloan(double p, float n)
			{
				var ln = new Personalloan(p, n);
				return ln;
			}
	
	}

}    //namespace closed....