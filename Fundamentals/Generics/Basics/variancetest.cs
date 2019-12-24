using System;

interface IStackReader<out V>
{
	V Pop();
	bool Empty();
}

interface IStackWriter<in V>
{
	void Push(V value);
}

class SimpleStack<V> : IStackReader<V>, IStackWriter<V>
{
	class Node
	{
		internal V value;
		internal Node below;

		internal Node(V val, Node node)
		{
			value = val;
			below = node;
		}
	}

	private Node top;

	public void Push(V value)
	{
		top = new Node(value, top);
	}

	public V Pop()
	{
		Node node = top;
		top = top.below;
		return node.value;
	}

	public bool Empty()
	{
		return top == null;
	}

	public void Copy(IStackWriter<V> target)
	{
		for(Node n = top; n != null; n = n.below)
			target.Push(n.value);		
	}
}

class FiniteStack<V> : IStackReader<V>, IStackWriter<V>
{
	private V[] values;
	private int count;

	public FiniteStack(int size)
	{
		values = new V[size];
	}

	public void Push(V value)
	{
		values[count++] = value;
	}	

	public V Pop()
	{
		return values[--count];
	}

	public bool Empty() => count == 0;
}



static class Program
{
	private static void PrintStack(IStackReader<object> stack)
	{
		for(int count = 0; !stack.Empty(); ++count)
		{
			if(count > 0)
				Console.Write(", ");
			Console.Write(stack.Pop());
		}

		Console.WriteLine();
	}

	public static void Main()
	{
		SimpleStack<string> a = new SimpleStack<string>();
		a.Push("Monday");
		a.Push("Tuesday");
		a.Push("Wednesday");
		a.Push("Thursday");
		a.Push("Friday");

		FiniteStack<string> b = new FiniteStack<string>(16);
		b.Push("June");
		b.Push("May");
		b.Push("April");
		b.Push("March");
		a.Copy(b);

		SimpleStack<Interval> c = new SimpleStack<Interval>();
		c.Push(new Interval(5, 31));
		c.Push(new Interval(3, 42));
		c.Push(new Interval(7, 13));
		c.Push(new Interval(6, 54));
		c.Push(new Interval(4, 25));

		SimpleStack<object> d = new SimpleStack<object>();
		d.Push("Sunday");
		d.Push(new Interval(2, 30));
		d.Push(34.5);
		c.Copy(d);

		PrintStack(a);
		PrintStack(b);
		PrintStack(c);
		PrintStack(d);
	}
}
