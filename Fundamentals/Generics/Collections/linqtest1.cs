using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

class SimpleStack<V> : IEnumerable<V>
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
	
	public IEnumerator<V> GetEnumerator()
	{
		for(Node n = top; n != null; n = n.below)
			yield return n.value;		
	}

	IEnumerator IEnumerable.GetEnumerator() => GetEnumerator();
}

static class Program
{
	public static void Main()
	{
		var source = new SimpleStack<int>();
		source.Push(1);
		source.Push(2);
		source.Push(3);
		source.Push(4);
		source.Push(5);
		source.Push(6);
		source.Push(7);
		source.Push(8);
		source.Push(9);

		/*		
		foreach(int n in source)
		{
			if((n % 2) == 1)
				Console.WriteLine(n * n);
		}
		*/

		//var selection = source.Where(n => (n % 2) == 1).Select(n => n * n); 
		var selection = from n in source where (n % 2) == 1 select n * n;
		foreach(var n in selection)
			Console.WriteLine(n);
	}
}
