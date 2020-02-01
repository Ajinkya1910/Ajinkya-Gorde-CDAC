using System;
using System.IO;
using System.Net;

static class Program
{
	public static void Main()
	{
		string[] items = {"cpu", "hdd", "keyboard", "memory", "monitor", "motherboard", "mouse"};
		double[] prices = {14000, 4500, 1200, 2000, 4000, 6000, 800};
		int[] stocks = {200, 300, 500, 550, 450, 350, 150};

		HttpListener listener = new HttpListener();
		listener.Prefixes.Add("http://*:8001/shop/");
		listener.Start();

		for(;;)
		{
			var client = listener.GetContext();
			string item = client.Request.QueryString["item"];
			StreamWriter writer = new StreamWriter(client.Response.OutputStream);
			int i = Array.IndexOf(items, item);
			if(i >= 0)
			{
				client.Response.ContentType = "text/plain";
				writer.WriteLine("Price={0}&Stock={1}", prices[i], stocks[i]);
			}
			else
				client.Response.StatusCode = 404;
			writer.Close();
		}
	}
}
