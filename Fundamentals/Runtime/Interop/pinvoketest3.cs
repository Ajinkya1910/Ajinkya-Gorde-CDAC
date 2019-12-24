using System;
using System.Runtime.InteropServices;

static class Program
{
	[StructLayout(LayoutKind.Sequential)]
	struct FixedDeposit
	{
		public int Id;
		public double Amount;
		public int Period;
	}

	[DllImport(@"legacy\bin\invest.dll")]
	private extern static int InitFixedDeposit(double amount, int period, out FixedDeposit fd);

	delegate float Scheme(int period);

	[DllImport(@"legacy\bin\invest.dll")]	
	private extern static double GetMaturityValue(in FixedDeposit fd, Scheme policy);

	public static void Main(string[] args)
	{
		double p = double.Parse(args[0]);
		int n = int.Parse(args[1]);
		FixedDeposit fd;

		InitFixedDeposit(p, n, out fd);
		Console.WriteLine("New fixed-deposit ID: {0}", fd.Id);

		double mv = GetMaturityValue(fd, y => y < 4 ? 6 : 7);
		Console.WriteLine("Maturity value: {0:0.00}", mv);
	}
}
