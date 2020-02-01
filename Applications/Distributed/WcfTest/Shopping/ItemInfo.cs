using System.Runtime.Serialization;

namespace Shopping
{
    [DataContract]
    public class ItemInfo
    {
        [DataMember]
        public double UnitPrice { get; set; }

        [DataMember]
        public int CurrentStock { get; set; }
    }

}
