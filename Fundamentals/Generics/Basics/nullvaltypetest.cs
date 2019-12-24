using System;

static class Program
{
	//private static Nullable<double> GetBalance(string name)
	private static double? GetBalance(string name)
	{
		string[] names = {"jack", "jill", "john", "jane"};
		double[] balances = {5000, 7000, 6000, 4000};
		int i = Array.IndexOf(names, name);

		if(i >= 0)
			return balances[i];

		return null;
	}

	public static void Main(string[] args)
	{
		double? bal = GetBalance(args[0]);

		if(bal == null)
			Console.WriteLine($"Cannot find {args[0]}");
		else
			Console.WriteLine($"Balance is {bal}");

		Console.WriteLine("Annual Interest: {0}", 0.04 * (bal ?? 0));
	}
}
