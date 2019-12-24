using System;

class Interval
{
	public int Minutes {get;}

	public int Seconds {get;}

	public Interval(int minutes, int seconds)
	{
		Minutes = minutes + seconds / 60;
		Seconds = seconds % 60;
	}

	public int GetTime()
	{
		return 60 * Minutes + Seconds;
	}	

	public void Print()
	{
		 Console.WriteLine($"{Minutes}:{Seconds:00}");
	}

	public static Interval operator+(Interval lhs, Interval rhs)
	{
		return new Interval(lhs.Minutes + rhs.Minutes, lhs.Seconds + rhs.Seconds);
	}

	public static Interval operator*(int lhs, Interval rhs)
	{
		return new Interval(lhs * rhs.Minutes, lhs * rhs.Seconds);
	}

	public static Interval operator++(Interval val)
	{
		return new Interval(val.Minutes, val.Seconds + 1);
	}

	public static explicit operator double(Interval val)
	{
		return val.Minutes + val.Seconds / 60.0;
	}

	//indexer - special property which can be accessed by applying [] to object 
	public int this[int index]
	{
		get
		{
			return index != 0 ? Minutes : Seconds;
		}
	}
	
}

static class Program
{
	public static void Main()
	{
		Interval a = new Interval(3, 65);
		a.Print();

		Interval b = new Interval(5, 35);
		b.Print();

		Interval c = a + b;
		c.Print();

		Interval d = 3 * a;
		d.Print();

		Interval e = ++b;
		e.Print();
		b.Print();

		Interval f = e++;
		f.Print();
		e.Print();

		Interval g = new Interval(8, 45);
		g.Print();

		double h = (double)g;
		Console.WriteLine(h);

		Console.WriteLine("Above Interval has {0} minutes and {1} seconds", g[1], g[0]);
	}
}
