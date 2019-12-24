using System;
using System.Collections.Generic;

static class Program
{
	public static void Main(string[] args)
	{
		IDictionary<string, Interval> store = new SortedList<string, Interval>();
		store.Add("monday", new Interval(4, 21));	
		store.Add("tuesday", new Interval(6, 52));
		store.Add("wednesday", new Interval(3, 43));
		store.Add("thursday", new Interval(7, 34));
		store.Add("friday", new Interval(5, 15));	

		if(args.Length > 0)
		{
			string key = args[0];
			if(store.ContainsKey(key))
			{
				Console.WriteLine("Value = {0}", store[key]);
			}
			else
			{
				Console.WriteLine("Cannot find {0}", key);
			}
		}
		else
		{
			foreach(var pair in store)
			{
				Console.WriteLine("{0, -12}{1}", pair.Key, pair.Value);
			}
		}
	}
}
