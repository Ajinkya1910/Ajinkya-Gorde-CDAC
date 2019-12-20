package shopping;

import java.util.*;
import java.rmi.*;

public class ShopKeeperImpl extends java.rmi.server.UnicastRemoteObject implements ShopKeeper{

	public ShopKeeperImpl() throws RemoteException{
		super(); //exports this object
	}

	public ItemInfo getItemInfo(String name) throws RemoteException{
		String[] items = {"cpu", "hdd", "keyboard", "memory", "monitor", "motherboard", "mouse"};
		double[] prices = {14000, 4500, 1200, 2000, 4000, 6000, 800};
		int[] stocks = {200, 300, 500, 550, 450, 350, 150};
		int id = Arrays.binarySearch(items, name);
		if(id >= 0){
			ItemInfo info = new ItemInfo();
			info.unitPrice = 1.06 * prices[id];
			info.currentStock = stocks[id];
			return info;
		}
		return null;
	}

	public float getBulkDiscount(int quantity) throws RemoteException{
		return quantity < 3 ? 0 : 5;
	}
}

