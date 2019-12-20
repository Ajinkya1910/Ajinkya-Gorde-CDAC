package shopping;

import java.rmi.*;

public class CartFactoryImpl extends java.rmi.server.UnicastRemoteObject implements CartFactory{

	public CartFactoryImpl() throws RemoteException{}

	public Cart create() throws RemoteException{
		return new CartImpl();
	}
}

