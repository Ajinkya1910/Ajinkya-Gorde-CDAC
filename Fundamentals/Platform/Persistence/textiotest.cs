using System;
using System.IO;

static class Program
{
	public static void Main(string[] args)
	{
		if(args.Length > 2)
		{
			string name = args[0];
			float price = float.Parse(args[1]);
			short stock = short.Parse(args[2]);

			var writer = new StreamWriter(new FileStream("product.txt", FileMode.Create));
			writer.WriteLine(price);
			writer.WriteLine(stock);
			writer.WriteLine(name);
			writer.Close();
		}
		else
		{
			var reader = new StreamReader(new FileStream("product.txt", FileMode.Open));
			float price = float.Parse(reader.ReadLine());
			short stock = short.Parse(reader.ReadLine());
			string name = reader.ReadLine();
			reader.Close();
			Console.WriteLine($"{name} {price} {stock}");
		}
	}
}
