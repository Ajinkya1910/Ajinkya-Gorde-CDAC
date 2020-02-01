using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ServiceModel;
using Shopping;

namespace ServerApp
{
    [ServiceBehavior(InstanceContextMode = InstanceContextMode.PerSession)]
    public class CartService : ICart
    {
        private double payment;

        public bool AddItem(string name)
        {
            string[] items = { "cpu", "hdd", "keyboard", "memory", "monitor", "motherboard", "mouse" };
            double[] prices = { 14000, 4500, 1200, 2000, 4000, 6000, 800 };

            int i = Array.IndexOf(items, name);
            if(i >= 0)
            {
                payment += 1.06 * prices[i];
                return true;
            }

            return false;

        }

        public double Checkout()
        {
            return payment;
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            ServiceHost host = new ServiceHost(typeof(CartService));
            host.Open();
            Console.ReadKey();
            host.Close();
        }
    }
}
