using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.ServiceModel;
using Sales;

namespace RichClientApp
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void orderButton_Click(object sender, EventArgs e)
        {
            string customerId = customerIdTextBox.Text.ToUpper();
            int productNo = int.Parse(productNoTextBox.Text);
            int quantity = int.Parse(quantityTextBox.Text);

            using(var service = new ChannelFactory<IOrderManager>("OrderManagerTcp"))
            {
                var client = service.CreateChannel();
                try
                {
                    int orderNo = client.PlaceOrder(customerId, productNo, quantity);
                    MessageBox.Show($"New order number is {orderNo}", "Order Placed", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                catch
                {
                    MessageBox.Show("Order cannot be placed with given inputs", "Order Failed", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
                    service.Abort();
                }
            }
        }
    }
}
