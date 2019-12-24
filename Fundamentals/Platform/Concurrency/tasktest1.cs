using System;
using System.Threading.Tasks;

class Computation
{
	private int low, high;

	public Computation(int l, int h)
	{
		low = l;
		high = h;
	}

	public long Compute()
	{
		long total = 0;

		for(int value = low; value <= high; ++value)
		{
			Worker.DoWork(value);
			total += value * value;
		}

		return total;
	}

}

static class Program
{
	public static void Main()
	{
		Console.Write("Limit 1/2: ");
		int m = int.Parse(Console.ReadLine());
		Computation c1 = new Computation(1, m);
		//long r1 = c1.Compute();
		Task<long> t1 = Task<long>.Factory.StartNew(c1.Compute);

		Console.Write("Limit 2/2: ");
		int n = int.Parse(Console.ReadLine());
		Computation c2 = new Computation(m + 1, n);
		//long r2 = c2.Compute();
		Task<long> t2 = Task<long>.Factory.StartNew(c2.Compute);

		//long r = r1 + r2;
		long r = t1.Result + t2.Result;
		Console.WriteLine("Final Result = {0}", r);

		 
	}
}
