using System;
using System.IO;
using System.Net;

static class Program
{
	public static void Main(string[] args)
	{
		string host = args.Length > 1 ? args[1] : "localhost";
		string item = args[0].ToLower();

		string url = $"http://{host}:8001/shop?item={item}";
		WebClient client = new WebClient();
		try
		{
			Stream s = client.OpenRead(url);
			StreamReader reader = new StreamReader(s);
			string response = reader.ReadLine();
			string[] info = response.Split('&');
			Console.WriteLine(info[0]);
			Console.WriteLine(info[1]);
			reader.Close();
		}
		catch(Exception ex)
		{
			Console.WriteLine("ERROR: {0}", ex.Message);
		}
	}
}
