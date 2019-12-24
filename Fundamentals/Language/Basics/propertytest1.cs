using System;

struct Rectangle
{
	private float length;
	private float breadth;

	public Rectangle(float l, float b)
	{
		length = l;
		breadth = b;
	}

	//property - special methods which can be called using field-access syntax 
	public float Length
	{
		get
		{
			return length;
		}

		set
		{
			length = value;
		}
	}

	public float Breadth
	{
		get => breadth;
		set => breadth = value;
	}

	//read-only property - no set method
	public float Perimeter
	{
		get => 2 * (length + breadth);
	}

	public float Area => length * breadth;
}

static class Program
{
	public static void Main()
	{
		Rectangle a = new Rectangle(25, 21);
		Rectangle b = new Rectangle();
		b.Length = b.Breadth = (a.Length + a.Breadth) / 2;

		Console.WriteLine("Perimeter of first rectangle = {0:0.00}", a.Perimeter);
		Console.WriteLine("Area of second rectangle = {0:0.00}", b.Area);

	}
}
