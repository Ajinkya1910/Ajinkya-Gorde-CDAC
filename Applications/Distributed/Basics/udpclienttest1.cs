using System;
using System.Text;
using System.Net;
using System.Net.Sockets;

static class Program
{
	public static void Main()
	{
		string[] symbols = {"APPL", "GOGL", "INTC", "MSFT", "ORCL"};
		Random rdm = new Random();

		UdpClient publisher = new UdpClient("230.0.0.1", 5001);
		for(;;)
		{
			int i = rdm.Next(0, symbols.Length);
			double price = 0.01 * rdm.Next(1000, 10000);
			string message = $"{symbols[i]} - {price:0.00}";
			byte[] data = Encoding.UTF8.GetBytes(message);
			publisher.Send(data, data.Length);
			System.Threading.Thread.Sleep(10000);
		} 
	}
}
