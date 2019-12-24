using System;

static class Program
{

	private static T Select<T>(int sign, T first, T second)
	{
		if(sign < 0)
			return first;
		return second;
	}


	public static void Main(string[] args)
	{
		int s = int.Parse(args[0]);
		
		string ss = Select(s, "Monday", "Tuesday");
		Console.WriteLine($"Selected string = {ss}");

		double sd = Select(s, 34.25, 23.75); 
		Console.WriteLine($"Selected double = {sd}");
	
		if(DateTime.Now.Day == 1)
		{	
			int si = Select(s, 1234, 0xabcd);
			Console.WriteLine($"Selected int = {si}");
		}

	}
}
