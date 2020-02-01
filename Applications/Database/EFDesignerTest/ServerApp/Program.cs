using System;
using System.ServiceModel;
using Sales;

namespace ServerApp
{
    [ServiceBehavior(InstanceContextMode = InstanceContextMode.PerCall)]
    public class OrderManagerMicroService : IOrderManager
    {
        [OperationBehavior(TransactionScopeRequired = true)]
        public int PlaceOrder(string customerId, int productNo, int quantity)
        {
            using(var shop = new ShopEntities())
            {
                Counter orderCounter = shop.Counters.Find("order");
                OrderDetail order = new OrderDetail
                {
                    OrderNo = ++orderCounter.CurrentValue + 1000,
                    OrderDate = DateTime.Now,
                    CustomerId = customerId,
                    ProductNo = productNo,
                    Quantity = quantity
                };

                shop.OrderDetails.Add(order);

                Product product = shop.Products.Find(productNo);
                product.Stock -= quantity;

                shop.SaveChanges();

                return order.OrderNo;
            }
                
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            ServiceHost host = new ServiceHost(typeof(OrderManagerMicroService));
            host.Open();
            Console.ReadKey();
            host.Close();
        }
    }
}
