using System;

delegate void QuoteEventHandler(object sender, QuoteEventArgs e);

class QuoteEventArgs : EventArgs
{
	public double QuoteValue {get;}

	public QuoteEventArgs(double value)
	{
		QuoteValue = value;
	}
}

//event source
class Publisher
{
	public event QuoteEventHandler Available;

	private double FetchQuote(int id)
	{
		int t = Environment.TickCount + 1000 * id;
		
		while(Environment.TickCount < t);

		return 0.01 * (1000 + t % 9000);
	}

	public void Publish(int count)
	{
		for(int id = 1; id <= count; ++id)
		{
			double quote = FetchQuote(id);
			
			//raise event
			QuoteEventArgs e = new QuoteEventArgs(quote);
			Available?.Invoke(this, e);
		}
	}
}

//event sink
class Subscriber
{	
	private Publisher pub = new Publisher();

	private void DisplayQuote(object sender, QuoteEventArgs e)
	{
		Console.WriteLine("Received quote with value of {0:0.00}", e.QuoteValue);
	}

	//contravariance for second parameter of QuoteEventHandler delegate
	private void ShowTime(object sender, EventArgs e)
	{
		Console.WriteLine(DateTime.Now);
		Console.WriteLine("--------------------------------");
	}

	public void Subscribe()
	{
		pub.Available += DisplayQuote;
		pub.Available += ShowTime;

		pub.Publish(5);		
	}
}

static class Program
{
	public static void Main()
	{
		Subscriber sub = new Subscriber();
		sub.Subscribe();
	}
}
