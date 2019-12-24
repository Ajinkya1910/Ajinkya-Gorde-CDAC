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
			if(check.Invoke(value))
				Console.Write(" {0}", value * value);
		}
		Console.WriteLine();
	}
}

static class Program
{
	private static bool IsOdd(int n)
	{
		return (n % 2) == 1;
	}

	//nested class
	class IsBiggerThan
	{
		private int lim;

		public IsBiggerThan(int limit)
		{
			lim = limit;
		}

		public bool Confirm(int val)
		{
			return val > lim;
		}
	}
	

	public static void Main()
	{
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Squares.Print("All", numbers);	
		Squares.PrintSelected("Odd", numbers, IsOdd);
		Squares.PrintSelected("Big", numbers, new IsBiggerThan(6).Confirm);

	}
}
