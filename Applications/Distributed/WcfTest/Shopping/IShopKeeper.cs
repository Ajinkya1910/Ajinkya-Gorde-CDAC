using System.ServiceModel;

namespace Shopping
{
    [ServiceContract]
    public interface IShopKeeper
    {
        [OperationContract]
        ItemInfo GetItemInfo(string name);

        [OperationContract]
        float GetBulkDiscount(int quantity);
    }
}
