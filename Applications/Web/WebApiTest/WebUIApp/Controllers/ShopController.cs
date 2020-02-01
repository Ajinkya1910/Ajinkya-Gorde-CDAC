using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.ServiceModel;
using Shopping;

namespace WebUIApp.Controllers
{
    using Models;

    public class ShopController : ApiController
    {
        public IHttpActionResult Get(string id)
        {
            var binding = new NetTcpBinding();
            var address = "net.tcp://localhost:4002/shopping/shopkeeper";

            using(var service = new ChannelFactory<IShopKeeper>(binding, address))
            {
                var client = service.CreateChannel();
                var info = client.GetItemInfo(id);
                if (info == null)
                    return NotFound();
                return Ok(info);
            }
        }

        public IHttpActionResult Post(OrderInput input)
        {
            var binding = new NetTcpBinding();
            var address = "net.tcp://localhost:4002/shopping/shopkeeper";

            using (var service = new ChannelFactory<IShopKeeper>(binding, address))
            {
                var client = service.CreateChannel();
                var info = client.GetItemInfo(input.Item);
                if (info?.CurrentStock < input.Quantity)
                    return NotFound();
                float discount = client.GetBulkDiscount(input.Quantity);
                OrderOutput output = new OrderOutput();
                output.Number = Environment.TickCount;
                output.Payment = input.Quantity * info.UnitPrice * (1 - discount / 100);
                return Ok(output);
                
            }
        }

    }
}
