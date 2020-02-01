using System;
using System.IO;
using System.Net;
using System.Net.Sockets;

static class Program
{
	public static void Main()
	{
		TcpListener listener = new TcpListener(IPAddress.Any, 4001);
		listener.Start();
		//Communicate(listener);
		for(int i = 0; i < 3; ++i)
		{
			var servant = new System.Threading.Thread(delegate()
			{
				Communicate(listener);
			});
			servant.Start();
		}
	}

	private static void Communicate(TcpListener server)
	{
		string[] items = {"cpu", "hdd", "keyboard", "memory", "monitor", "motherboard", "mouse"};
		double[] prices = {14000, 4500, 1200, 2000, 4000, 6000, 800};
		int[] stocks = {200, 300, 500, 550, 450, 350, 150};

		for(;;)
		{
			TcpClient client = server.AcceptTcpClient();
			Stream channel = client.GetStream();
			StreamReader reader = new StreamReader(channel);
			StreamWriter writer = new StreamWriter(channel);
			writer.AutoFlush = true;
			client.ReceiveTimeout = 60000;

			try
			{
				writer.WriteLine("Welcome to our shop!");
				string item = reader.ReadLine();
				int i = Array.IndexOf(items, item);
				if(i >= 0)
					writer.WriteLine("Price={0}&Stock={1}", prices[i], stocks[i]);
				else
					writer.WriteLine();
			}
			catch(Exception ex)
			{
				Console.WriteLine("Communication Failure: {0}", ex.Message);
			}

			writer.Close();
			reader.Close();
			client.Close(); 
		}
	}
}
