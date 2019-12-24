using System;
using System.Collections.Generic;

static class Program
{
	class IntervalComparison : IComparer<Interval>
	{
		public int Compare(Interval x, Interval y)
		{
			return x.Seconds - y.Seconds;
		}
	}

	public static void Main()
	{
		//ISet<Interval> store = new SortedSet<Interval>();
		ISet<Interval> store = new SortedSet<Interval>(new IntervalComparison());
		store.Add(new Interval(4, 21));	
		store.Add(new Interval(6, 52));
		store.Add(new Interval(3, 43));
		store.Add(new Interval(7, 34));
		store.Add(new Interval(5, 15));	
		store.Add(new Interval(2, 141));

		foreach(Interval i in store)
			Console.WriteLine(i);
	}
}
