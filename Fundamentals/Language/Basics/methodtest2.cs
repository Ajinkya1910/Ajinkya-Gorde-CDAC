using System;

static class Program
{
	private static double GetIncome(double invest, int duration=3, string risk="medium")
	{
		float rate;

		switch(risk)
		{
			case "low":
				rate = 6;
				break;
			case "high":
				rate = 8.5f;
				break;
			default:
				rate = 7;
				break;
		}

		double amount = invest * Math.Pow(1 + rate / 100, duration);

		return amount - invest;
	}

	public static void Main(string[] args)
	{
		try
		{
			double p = double.Parse(args[0]);
			Console.WriteLine("Income in bronze scheme: {0:0.00}", GetIncome(p, 2, "low"));	
			Console.WriteLine("Income in silver scheme: {0:0.00}", GetIncome(p, 4));	
			Console.WriteLine("Income in gold scheme  : {0:0.00}", GetIncome(p, risk : "high"));	
		}
		catch(IndexOutOfRangeException)
		{
			Console.WriteLine("Usage: methodtest2 amount-to-invest");
		}
		catch(FormatException)
		{
			Console.WriteLine("Error: amount-to-invest must be a number!");
		}
	}
}
