package shopping;

import java.rmi.*;

public interface Cart extends Remote{

	boolean addItem(String name) throws RemoteException;

	double checkout() throws RemoteException;
}

