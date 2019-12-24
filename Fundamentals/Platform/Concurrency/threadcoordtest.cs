using System;
using System.Threading;

static class Program
{
	private static volatile int value = 0;
	private static object coordinator = new object();
	
	private static void Consume()
	{
		Console.WriteLine("Consumer<{0}> ready...", Thread.CurrentThread.ManagedThreadId);

		//while(value == 0) Thread.Yield();
		lock(coordinator)
		{
			Monitor.Wait(coordinator);
			Console.WriteLine("Processed value = {0}", value * value);
		}
	}

	private static void Produce()
	{
		Console.WriteLine("Producer<{0}> ready...", Thread.CurrentThread.ManagedThreadId);

		int result = Worker.DoWork();
		
		lock(coordinator)
		{
			value = result;
			Monitor.Pulse(coordinator);
		}

	}

	public static void Main()
	{
		var producer = new Thread(Produce);
		producer.Start();
	
		var consumer = new Thread(Consume);
		consumer.Start();
	}
}	