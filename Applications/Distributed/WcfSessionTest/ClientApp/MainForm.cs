using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClientApp
{
    public partial class MainForm : Form
    {
        CartClient client = new CartClient();

        public MainForm()
        {
            InitializeComponent();
        }

        private async void addButton_Click(object sender, EventArgs e)
        {
            string item = itemTextBox.Text.ToLower();
            if (await client.AddItemAsync(item))
            {
                basketListBox.Items.Add(item);
            }
            else
                MessageBox.Show($"Cannot add {item} to the cart", "ClientApp", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
        }

        private async void checkoutButton_Click(object sender, EventArgs e)
        {
            double payment = await client.CheckoutAsync();
            MessageBox.Show($"Total payment is {payment:0.00}", "ClientApp", MessageBoxButtons.OK, MessageBoxIcon.Information);
            this.Close();
        }
    }
}
