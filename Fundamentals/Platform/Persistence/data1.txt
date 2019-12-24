using System;
using System.IO;

static class Program
{
	public static void Main(string[] args)
	{
		using(var source = new FileStream(args[0], FileMode.Open))
		{
			using(var target = new FileStream(args[1], FileMode.CreateNew))
			{
				byte[] buffer = new byte[80];
				while(source.Position < source.Length)
				{
					int n = source.Read(buffer, 0, buffer.Length);
					for(int i = 0; i < n; ++i)
						buffer[i] = (byte)(buffer[i] ^ '#');
					target.Write(buffer, 0, n);
				}
			}
		}
	}
}
