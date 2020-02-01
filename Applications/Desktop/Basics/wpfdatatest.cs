using System;
using System.Threading;
using System.Windows;
using System.Windows.Data;

class Clock : DependencyObject
{
	public static readonly DependencyProperty TimeProperty = DependencyProperty.Register("Time", typeof(string), typeof(Clock));

	public string Time
	{
		get { return (string) GetValue(TimeProperty); }
		set { SetValue(TimeProperty, value); }
	}

	public Clock()
	{
		Thread child = new Thread(Run);
		child.IsBackground = true;
		child.Start();
	}

	private void Run()
	{
		for(;;)
		{	
			//called by child thread
			this.Dispatcher.Invoke(delegate()
			{	
				//executed by the owner of this object
				this.Time = DateTime.Now.ToString();
			});
			Thread.Sleep(1000);
		}
	}
}

class MainWindow : Window
{
	public MainWindow()
	{
		this.Title = "Hello World!";

		Binding clockTimeBinding = new Binding("Time");
		clockTimeBinding.Source = new Clock();

		this.SetBinding(ContentProperty, clockTimeBinding);		
	}

}	

static class Program
{
	[STAThread]
	public static void Main()
	{
		Application app = new Application();
		app.Run(new MainWindow());
	}
}
