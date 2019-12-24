using System;

class Customer
{
	//auto-property
	public string Name {get; set;}

	//auto-property with initializer
	public decimal Credit {get; set;} = 5000;	
}

static class Program
{
	public static void Main()
	{
		Customer a = new Customer();
		a.Name = "Jack";
		a.Credit = 6000;
		Console.WriteLine($"{a.Name}'s credit is {a.Credit}");

		//object initializer syntax
		Customer b = new Customer {Name="Jill", Credit=7000};
		Console.WriteLine($"{b.Name}'s credit is {b.Credit}");
		
		//implicitly typed local (var=Customer)
		var c = new Customer {Name = "John"};
		Console.WriteLine($"{c.Name}'s credit is {c.Credit}");

		//anonymous type
		var d = new {Id=23, Score=61.5};
		Console.WriteLine($"Score of student with ID {d.Id} is {d.Score}");
	}
}
