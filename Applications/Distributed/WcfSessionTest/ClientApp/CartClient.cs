using System.Threading.Tasks;
using System.ServiceModel;
using Shopping;

namespace ClientApp
{
    class CartClient : ClientBase<ICart>
    {
        public CartClient() : base("CartHttp")
        {
        }

        public Task<bool> AddItemAsync(string name)
        {
            return Task<bool>.Run(() => Channel.AddItem(name));
        }

        public Task<double> CheckoutAsync()
        {
            return Task<double>.Run(() => Channel.Checkout());
        }
    }
}
