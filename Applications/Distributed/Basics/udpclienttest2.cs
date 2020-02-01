using System;
using System.Text;
using System.Net;
using System.Net.Sockets;

static class Program
{
	public static void Main()
	{
		IPAddress addr = IPAddress.Parse("230.0.0.1");
		UdpClient subscriber = new UdpClient(5001);
		subscriber.JoinMulticastGroup(addr);

		IPEndPoint remote = null;
		for(int i = 0; i < 5; ++i)
		{
			byte[] data = subscriber.Receive(ref remote);
			string message = Encoding.UTF8.GetString(data);
			Console.WriteLine(message);
		}

		subscriber.DropMulticastGroup(addr);
		subscriber.Close();

	}
}
