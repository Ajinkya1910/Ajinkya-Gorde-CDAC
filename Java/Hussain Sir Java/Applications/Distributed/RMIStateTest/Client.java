import shopping.*;
import java.rmi.*;

class Client{
	
	public static void main(String[] args) throws Exception{
		CartFactory client = (CartFactory)Naming.lookup("rmi://localhost:2099/shopping/cartFactory");
		Cart cart = client.create();
		for(int i = 0; i < args.length;++i){
			String item = args[i].toLowerCase();
			System.out.printf("Adding %s to the cart...", item);
			if(cart.addItem(item))
				System.out.println("Succeeded.");
			else
				System.out.println("Failed!");
		}
		double payment = cart.checkout();
		System.out.printf("Total payment: %.2f%n", payment);
	}
}



