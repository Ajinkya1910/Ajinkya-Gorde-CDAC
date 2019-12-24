using QuadEq;
using System;

static class Program
{
	public static void Main(string[] args)
	{
		double perim = double.Parse(args[0]);
		double area = double.Parse(args[1]);
		double a = 1, b = -perim / 2, c = area;

		var qe = new QuadraticEquationClass(); //new returns RCW of COM object created from metadata of imported class
	
		if(qe.HasRealRoots(a, b, c) != 0)
		{
			double r1, r2;
			qe.Solve(a, b, c, out r1, out r2);
			Console.WriteLine("Dimensions = {0}, {1}", r1, r2);
		}
		else
			Console.WriteLine("No such rectangle!");
	}
}
