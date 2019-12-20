package shopping;

import java.rmi.*;

public interface CartFactory extends Remote{

	Cart create() throws RemoteException;
}

