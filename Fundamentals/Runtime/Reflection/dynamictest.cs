using System;
using System.Dynamic;

class FormalGreeter
{
	public string Meet(string name)
	{
		return $"Hello {name}";
	}

	public string Leave(string name)
	{
		return $"Goodbye {name}";
	}
}

class CasualGreeter : DynamicObject
{
	public string Meet(string name)
	{
		return $"Hi {name}";
	}

	public string Leave(string name)
	{
		return $"Bye {name}";
	}

	public override bool TryInvokeMember(InvokeMemberBinder method, object[] arguments, out object result)
	{
		if(arguments.Length == 1)
		{
			result = $"{method.Name}ing {arguments[0]}";		
			return true;
		}

		result = null;
		return false;
	}
}

static class Program
{
	public static void Main(string[] args)
	{
		Type t = Type.GetType(args[0]);
		dynamic g = Activator.CreateInstance(t); //compiler generates runtime binder (DLR) call-sites for methods invoked on g

		Console.WriteLine(g.Meet("Jack")); // compiler does not check for methods (duck typing)
		Console.WriteLine(g.Leave("Jack"));

		try
		{
			Console.WriteLine(g.Kick("Jack"));
			Console.WriteLine(g.Punch("Jack", 3));
		}
		catch(Exception ex)
		{
			Console.WriteLine(ex.Message);
		}
	}
}
