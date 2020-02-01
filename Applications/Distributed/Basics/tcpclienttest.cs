using System;
using System.IO;
using System.Net.Sockets;

static class Program
{
	public static void Main(string[] args)
	{
		string host = args.Length > 1 ? args[1] : "localhost";
		string item = args[0].ToLower();

		TcpClient client = new TcpClient(host, 4001);
		Stream channel = client.GetStream();
		StreamReader reader = new StreamReader(channel);
		StreamWriter writer = new StreamWriter(channel);

		Console.WriteLine(reader.ReadLine());
		writer.WriteLine(item);
		writer.Flush();
		string response = reader.ReadLine();
		if(response.Length != 0)
		{
			string[] info = response.Split('&');
			Console.WriteLine(info[0]);
			Console.WriteLine(info[1]);	
		}
		else
			Console.WriteLine("Not available");

		writer.Close();
		reader.Close();
		client.Close();
	}
}