using System;

interface IConsumer : IDisposable
{
	void Apply(int action);
}

static class Consumers
{
	//extension-method: a method of a static class which can be called as
	//an instance method of its first 'this' qualified parameter type
	public static void ApplyAll(this IConsumer that, int first, int last)
	{
		for(int action = first; action <= last; ++action)
			that.Apply(action);
	}
}

class ResourceConsumer : IConsumer
{
	private string id;

	public ResourceConsumer(string name)
	{
		id = name;
		Console.WriteLine($"{id} resource acquired.");
	}

	//explicit implementation of Apply method defined in IConsumer interface
	void IConsumer.Apply(int action)
	{
		Console.WriteLine($"{id} resource consumed using action<{action}>");
	}

	void IDisposable.Dispose()
	{
		Console.WriteLine($"{id} resource released.");
	}
}

static class Program
{
	private static void Run(string up)
	{
		using(IConsumer b = new ResourceConsumer("Second"))
		{
			b.ApplyAll(1, int.Parse(up)); //Consumers.ApplyAll(b, 1, ...);
		}
		
	}
	
	public static void Main(string[] args)
	{
		IConsumer a = new ResourceConsumer("First");
		a.Apply(1);
		a.Dispose();

		try
		{
			Run(args[0]);
		}
		catch {}
	}
}
