import java.rmi.*;

class Server{

	public static void main(String[] args) throws Exception{
		Naming.rebind("shopping/shopKeeper", new shopping.ShopKeeperImpl());
	}
}

