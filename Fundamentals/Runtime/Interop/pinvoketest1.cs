using System;
using System.Runtime.InteropServices;

static class Program
{
	[DllImport("legacy\\bin\\asset.dll", EntryPoint="DDB")]
	private extern static double GetPriceAfter(double cost, short life, short after);

	public static void Main(string[] args)
	{
		double c = double.Parse(args[0]);
		short l = short.Parse(args[1]);

		for(short a = 1; a <= l; ++a)
			Console.WriteLine("{0}\t{1}", a, GetPriceAfter(c, l, a));
	}
}
