using System;

class SimpleStack<V>
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
}

static class Program
{
	public static void Main()
	{
		SimpleStack<string> a = new SimpleStack<string>();
		a.Push("Monday");
		a.Push("Tuesday");
		a.Push("Wednesday");
		a.Push("Thursday");
		a.Push("Friday");

		SimpleStack<string> b = new SimpleStack<string>();
		b.Push("June");
		b.Push("May");
		b.Push("April");
		b.Push("March");

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

		while(!a.Empty())
			Console.WriteLine(a.Pop());
		Console.WriteLine("---------------------");

		while(!b.Empty())
			Console.WriteLine(b.Pop());
		Console.WriteLine("---------------------");

		while(!c.Empty())
			Console.WriteLine(c.Pop());
		Console.WriteLine("---------------------");

		while(!d.Empty())
			Console.WriteLine(d.Pop());


	}
}
