using System;

delegate bool Selector(int value);

class Squares
{
	public static void Print(string prefix, int[] values)
	{
		Console.Write("{0} squares:", prefix);
		foreach(int value in values)
		{
			Console.Write(" {0}", value * value);
		}
		Console.WriteLine();
	}

	public static void PrintSelected(string prefix, int[] values, Selector check)
	{
		Console.Write("{0} squares:", prefix);
		foreach(int value in values)
		{
			if(check(value))
				Console.Write(" {0}", value * value);
		}
		Console.WriteLine();
	}
}

static class Program
{
	public static void Main()
	{
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Squares.Print("All", numbers);	
		//passing anonymous method 
		Squares.PrintSelected("Odd", numbers, delegate(int n){return (n % 2) == 1;});
		//passing lambda expression (arguments) => expression
		Squares.PrintSelected("Big", numbers, n => n > 6);

	}
}
