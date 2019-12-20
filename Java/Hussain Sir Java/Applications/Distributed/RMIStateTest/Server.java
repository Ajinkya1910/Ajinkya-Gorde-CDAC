import java.rmi.*;

class Server{

	public static void main(String[] args) throws Exception{
		java.rmi.registry.LocateRegistry.createRegistry(2099);
		Naming.bind("//localhost:2099/shopping/cartFactory", new shopping.CartFactoryImpl());
	}
}

