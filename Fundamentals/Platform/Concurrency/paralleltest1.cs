using System;
using System.Threading.Tasks;

static class Program
{
	public static void Main()
	{
		var clock = new System.Diagnostics.Stopwatch();
		clock.Start();

		long result = 0;

		#if NOPARALLEL
		for(int i = 1; i < 21; ++i)
		{
			Worker.DoWork(i);
			result += i * i;
		}
		#else
		Parallel.For(1, 21, i => 
		{
			Worker.DoWork(i);
			result += i * i;
		});
		#endif	
		clock.Stop();
		Console.WriteLine("Result = {0}", result);
		Console.WriteLine("Time = {0}", clock.Elapsed);
	}
}
