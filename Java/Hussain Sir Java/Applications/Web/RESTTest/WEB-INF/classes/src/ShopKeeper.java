package shopping;

import java.rmi.*;

public interface ShopKeeper extends Remote{

	ItemInfo getItemInfo(String name) throws RemoteException;

	float getBulkDiscount(int quantity) throws RemoteException;
}

