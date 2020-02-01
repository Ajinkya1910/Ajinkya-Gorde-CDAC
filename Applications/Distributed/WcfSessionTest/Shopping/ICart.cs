using System.ServiceModel;

namespace Shopping
{
    [ServiceContract(SessionMode = SessionMode.Required)]
    public interface ICart
    {
        [OperationContract]
        bool AddItem(string name);

        [OperationContract(IsTerminating = true)]
        double Checkout();
    }

}
