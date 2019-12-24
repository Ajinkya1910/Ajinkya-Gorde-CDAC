using System;
using System.Linq;
using System.Xml.Linq;

static class Program
{
	public static void Main(string[] args)
	{
		int lim = args.Length > 0 ? int.Parse(args[0]) : 0;
		XElement dept = XElement.Load("dept.xml");

		var selection = from e in dept.Element("Employees").Elements("Employee")
				where (int)e.Element("Experience") > lim
				select new
				{
					Id = (string)e.Attribute("Code"),
					Income = (double)e.Element("Salary")
				};

		foreach(var entry in selection)
			Console.WriteLine($"{entry.Id}\t{entry.Income}");
	}
}
