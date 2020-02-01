using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ComponentApp
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void personTextBox_TextChanged(object sender, EventArgs e)
        {
            greetButton.Enabled = personTextBox.TextLength > 2;
        }

        private void greetButton_Click(object sender, EventArgs e)
        {
            //simpleGreeter.Name = personTextBox.Text;
            //simpleGreeter.Interval = periodComboBox.Text;
            outputLabel.Text = simpleGreeter.Greet();
            if (simpleGreeter.GreetCount == 5)
                simpleGreeter.Reset();

        }

        private void MainForm_Load(object sender, EventArgs e)
        {
            greeterBindingSource.Add(simpleGreeter);
        }
    }
}
