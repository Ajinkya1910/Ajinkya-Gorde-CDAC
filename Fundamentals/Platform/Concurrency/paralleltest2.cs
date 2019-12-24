using System;
using System.Linq;
using System.Threading.Tasks;

static class Program
{
	public static void Main()
	{
		var clock = new System.Diagnostics.Stopwatch();
		clock.Start();

		var source = Enumerable.Range(1, 20);
		#if NOPARALLEL
		var result = (from n in source select n * Worker.DoWork(n)).Sum();
		#else
		var result = (from n in source.AsParallel() select n * Worker.DoWork(n)).Sum();
		#endif
		clock.Stop();
		Console.WriteLine("Result = {0}", result);
		Console.WriteLine("Time = {0}", clock.Elapsed);
	}
}
