using System;
using System.Windows.Forms;
using System.Drawing;
using System.Threading.Tasks;

class Computation
{
	public long Compute(int low, int high)
	{
		long total = 0;

		for(int value = low; value <= high; ++value)
		{
			Worker.DoWork(value);
			total += value * value;
		}

		return total;
	}
	
	public Task<long> ComputeAsync(int low, int high)
	{
		return Task<long>.Run(() => Compute(low, high));
	}

	

}

class MainForm : Form
{
	private Label outputLabel;
	private Button computeButton;

	public MainForm()
	{
		this.Text = "Hello World!";

		outputLabel = new Label();
		outputLabel.Text = "Ready";
		outputLabel.Location = new Point(30, 30);
		outputLabel.Size = new Size(200, 20);
		this.Controls.Add(outputLabel);

		computeButton = new Button();
		computeButton.Text = "Compute";
		computeButton.Location = new Point(30, 60);
		computeButton.Size = new Size(75, 25);
		computeButton.Click += ComputeButton_Click;
		this.Controls.Add(computeButton);		
	}

	private async void ComputeButton_Click(object sender, EventArgs e)
	{
		computeButton.Enabled = false;
		
		Computation c = new Computation();
		int m = Environment.TickCount % 10 + 20;
		long r = await c.ComputeAsync(1, m);

		outputLabel.Text = $"Result = {r}";
		computeButton.Enabled = true;
	}

}

static class Program
{
	[STAThread]
	public static void Main()
	{
		Application.Run(new MainForm());
	}
}
