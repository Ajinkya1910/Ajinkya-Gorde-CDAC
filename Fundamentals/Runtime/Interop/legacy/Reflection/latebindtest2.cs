using System;
using RateFunc = System.Func<double, int, float>;

//delegate float RateFunc(double p, int n);

static class Program
{
	public static void Main(string[] args)
	{
		double p = double.Parse(args[0]);
		Type t = Type.GetType(args[1]);
		object pol = Activator.CreateInstance(t);
		var rf = (RateFunc)Delegate.CreateDelegate(typeof(RateFunc), pol, args[2]);
		int m = 10;

		for(int n = 1; n <= m; ++n)
		{
			float r = rf(p, n);
			float i = r / 1200;
			double e = p * i / (1 - Math.Pow(1 + i, -12 * n));
			Console.WriteLine("{0, -6}{1, 12:0.00}", n, e);
		}
	}
}
