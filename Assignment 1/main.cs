using System;
using Banking;

static class Program
{	
	
	private static double GetTotalEMI(loan[] emi)
	{
		double total=0;

		foreach(var a in emi)
		{
			total = total + a.GetEMI();
		}
	
		return total;
	}

	public static void Main()

	{
		loan[] bank = new loan[2];
		bank[0] = Applyloan.ApplyHomeloan(1000000,10);

		bank[1] = Applyloan.ApplyPersonalloan(500000,5);

		float a = (float) GetTotalEMI(bank);

		Console.WriteLine("THE REQUIRED EMI is = {0}" ,a);
	}

}