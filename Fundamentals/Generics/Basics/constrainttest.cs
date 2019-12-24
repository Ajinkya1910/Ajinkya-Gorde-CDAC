using System;

static class Program
{

	private static T Select<T>(T first, T second) where T : IComparable<T>
	{
		if(first.CompareTo(second) > 0)
			return first;
		return second;
	}

	public static void Main()
	{		
		string ss = Select("Monday", "Tuesday");
		Console.WriteLine($"Selected string = {ss}");

		double sd = Select(34.25, 23.75); 
		Console.WriteLine($"Selected double = {sd}");

		Interval si = Select(new Interval(3, 45), new Interval(2, 30));
		Console.WriteLine($"Selected Interval = {si}");

	
	}
}
