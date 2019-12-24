using System;

static class Program
{
	public static void Main(string[] args)
	{
		double w = double.Parse(args[0]);
		double d = double.Parse(args[1]);

		Type t = Type.GetTypeFromProgID("METLogistics.AirCargo");
		dynamic cargo = Activator.CreateInstance(t);

		Console.WriteLine("Total Payment: {0:0.00}", cargo.QuoteTariff(w, d));
		Console.WriteLine("Time Required: {0:0.0}", cargo.EstimateTime(d));
	}
}
