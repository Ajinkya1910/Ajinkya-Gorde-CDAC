using System;

namespace Finance
{
	public interface ILoanPolicy
	{
		float GetInterestRate(double amount, int period);
	} 

	[AttributeUsage(AttributeTargets.Class)]
	public class MaxDurationAttribute : Attribute
	{
		public int Limit {get; set;}

		public MaxDurationAttribute(int limit = 5)
		{
			Limit = limit;
		}
	}

	[MaxDuration] 
	public class EducationLoan : ILoanPolicy
	{
		public float GetInterestRate(double p, int n) => 6;
	}

	public class HomeLoan : ILoanPolicy
	{
		public float GetInterestRate(double p, int n) => 8.0f + 0.5f * (n / 5);
	}

	[MaxDuration(4)]
	public class PersonalLoan : ILoanPolicy
	{
		public float GetInterestRate(double p, int n) => p < 100000 ? 9.5f : 10.5f;

		public float GetInterestRateForEmployees(double p, int n) => p < 300000 ? 6.5f : 7.5f;
	}

	[Serializable]
	public class BusinessLoan
	{
		public float RateOfInterest(double p, int n)
		{
			return (p < 1000000 ? 10 : 11) + (n < 3 ? 0 : 1);
		}
	}
}

