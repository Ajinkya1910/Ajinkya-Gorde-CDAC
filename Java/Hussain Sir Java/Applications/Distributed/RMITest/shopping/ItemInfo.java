package shopping;

public class ItemInfo implements java.io.Serializable{
	
	double unitPrice;
	int currentStock;

	public final double getUnitPrice(){return unitPrice;}

	public final int getCurrentStock(){return currentStock;}

}


