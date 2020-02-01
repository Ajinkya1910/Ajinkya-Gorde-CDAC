using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.ServiceModel;
using Shopping;

namespace ServerApp
{
    [ServiceBehavior(InstanceContextMode = InstanceContextMode.Single)]
    public class ShopKeeperService : IShopKeeper
    {
        public float GetBulkDiscount(int quantity)
        {
            return quantity < 3 ? 0 : 5;
        }

        public ItemInfo GetItemInfo(string name)
        {
            string[] items = { "cpu", "hdd", "keyboard", "memory", "monitor", "motherboard", "mouse" };
            double[] prices = { 14000, 4500, 1200, 2000, 4000, 6000, 800 };
            int[] stocks = { 200, 300, 500, 550, 450, 350, 150 };

            int i = Array.IndexOf(items, name);
            if(i >= 0)
            {
                ItemInfo info = new ItemInfo();
                info.UnitPrice = 1.06 * prices[i];
                info.CurrentStock = stocks[i];
                return info;
            }

            return null;               
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            ServiceHost host = new ServiceHost(typeof(ShopKeeperService));
            host.AddServiceEndpoint(typeof(IShopKeeper), new NetTcpBinding(), "net.tcp://localhost:4002/shopping/shopkeeper");
            host.Open();
            Console.ReadKey();
            host.Close();
        }
    }
}
