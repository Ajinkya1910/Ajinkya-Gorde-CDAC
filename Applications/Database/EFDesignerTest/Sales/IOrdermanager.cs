using System.ServiceModel;

namespace Sales
{
    [ServiceContract]
    public interface IOrderManager
    {
        [OperationContract]
        int PlaceOrder(string customerId, int productNo, int quantity);
    }
}
