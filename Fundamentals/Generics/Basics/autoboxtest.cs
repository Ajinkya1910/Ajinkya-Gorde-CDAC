using System;

static class Program
{
	/*
	private static string Select(int sign, string first, string second)
	{
		if(sign < 0)
			return first;
		return second;
	}

	private static double Select(int sign, double first, double second)
	{
		if(sign < 0)
			return first;
		return second;
	}
	*/

	private static object Select(int sign, object first, object second)
	{
		if(sign < 0)
			return first;
		return second;
	}


	public static void Main(string[] args)
	{
		int s = int.Parse(args[0]);
		
		string ss = (string)Select(s, "Monday", "Tuesday");
		Console.WriteLine($"Selected string = {ss}");

		double sd = (double)Select(s, 34.25, 23.75); //boxing for 2nd and 3rd arguments, unboxing for return-value
		Console.WriteLine($"Selected double = {sd}");

		if(DateTime.Now.Day == 1)
		{	
			int si = (int)Select(s, 1234, "abcd");
			Console.WriteLine($"Selected int = {si}");
		}

	}
}
