using FinanceLib;
using System;
using System.Runtime.InteropServices;

[ComImport]
[Guid("1A87402F-A9F3-449F-ACB3-714A9275BEE0")]
class Loan {}

class CarLoanScheme : ILoanScheme
{
	public float GetInterestRate(short n)
	{
		return 9.5f + 0.5f * (n / 3);
	}
}

static class Program
{
	[STAThread]
	public static void Main(string[] args)
	{
		double p = double.Parse(args[0]);
		short n = short.Parse(args[1]);

		ILoan loan = (ILoan) new Loan();

		try
		{
			loan.Acquire(p, n);
			Console.WriteLine("Monthly installment for home-loan: {0:0.00}", loan.GetInstallmentUsingRate(8.5f));	
			Console.WriteLine("Monthly installment for car-loan : {0:0.00}", loan.GetInstallmentForScheme(new CarLoanScheme())); //CCW of managed object will be passed to method of COM object
		}
		catch(COMException ex)
		{
			Console.WriteLine("Loan denied: {0}", (LoanError)ex.HResult);
		}
	}
}
