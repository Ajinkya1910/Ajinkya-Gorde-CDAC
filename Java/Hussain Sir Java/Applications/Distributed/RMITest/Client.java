import shopping.*;
import java.rmi.*;

class Client{
	
	public static void main(String[] args) throws Exception{
		String item = args[0].toLowerCase();
		int quantity = Integer.parseInt(args[1]);
		ShopKeeper client = (ShopKeeper)Naming.lookup("rmi://localhost/shopping/shopKeeper");
		ItemInfo info = client.getItemInfo(item);
		if(info != null && quantity <= info.getCurrentStock()){
			float discount = client.getBulkDiscount(quantity);
			double payment = quantity * info.getUnitPrice() * (1 - discount / 100);
			System.out.printf("Total payment: %.2f%n", payment);
		}else{
			System.out.println("Not available!");
		}
		
	}
}



