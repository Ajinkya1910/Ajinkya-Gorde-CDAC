using System;

static class Program
{
	private static void Swap(ref double first, ref double second)
	{
		double third = first;
		first = second;
		second = third;
	}

	private static double Average(double first, double second, out double deviation)
	{
		deviation = first > second ? (first - second) / 2 : (second - first) / 2;
		return (first + second) / 2;
	}

	public static void Main(string[] args)
	{
		double x = double.Parse(args[0]);
		double y = double.Parse(args[1]);
		Console.WriteLine($"Original values = {x}, {y}");
		Swap(ref x, ref y); //passing initialized variables by reference
		Console.WriteLine($"Swapped values  = {x}, {y}");

		double d;
		double a = Average(x, y, out d); //passing uninitialized variable by reference
		Console.WriteLine($"Their average is {a} with a deviation of {d:0.00}");
	}
}
