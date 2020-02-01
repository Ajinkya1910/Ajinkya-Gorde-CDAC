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
using Shopping;

namespace ClientApp
{
    public partial class MainForm : Form
    {
        NetTcpBinding binding = new NetTcpBinding();
        string address = "net.tcp://localhost:4002/shopping/shopkeeper";

        public MainForm()
        {
            InitializeComponent();
        }

        private void purchaseButton_Click(object sender, EventArgs e)
        {
            string item = itemTextBox.Text.ToLower();
            int quantity = (int)quantityNumericUpDown.Value;

            using(var service = new ChannelFactory<IShopKeeper>(binding, address))
            {
                IShopKeeper client = service.CreateChannel();
                ItemInfo info = client.GetItemInfo(item);
                if (info?.CurrentStock >= quantity) 
                {
                    float discount = client.GetBulkDiscount(quantity);
                    double payment = quantity * info.UnitPrice * (1 - discount / 100);
                    paymentTextBox.Text = payment.ToString("0.00");
                }
                else
                    paymentTextBox.Text = "n/a";
            }
        }
    }
}
