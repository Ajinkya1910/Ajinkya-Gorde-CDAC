using System;
using System.Linq;
using System.Collections.Generic;

static class Program
{
	public static void Main(string[] args)
	{
		int limit = args.Length > 0 ? int.Parse(args[0]) : 0;
		double distance = 500.0;
		List<Interval> store = new List<Interval>
		{
			new Interval(4, 31),
			new Interval(6, 52),
			new Interval(7, 23),
			new Interval(5, 14),
			new Interval(2, 45),
			new Interval(3, 26)
		};
		
		var selection = from i in store
				where i.GetTime() > limit
				orderby i.Seconds descending
				select new
				{
					Duration = i,
					Speed = 3.6 * distance / i.GetTime()
				};
		foreach(var item in selection)
			Console.WriteLine("{0}\t{1:0.0}", item.Duration, item.Speed);	
	}
}
