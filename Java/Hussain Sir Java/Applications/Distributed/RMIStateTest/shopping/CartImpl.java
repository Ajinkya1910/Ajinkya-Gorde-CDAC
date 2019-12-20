package shopping;

import java.util.*;
import java.rmi.*;

public class CartImpl extends java.rmi.server.UnicastRemoteObject implements Cart{

	private double payment = 0;

	public CartImpl() throws RemoteException{}

	public boolean addItem(String name) throws RemoteException{
		String[] items = {"cpu", "hdd", "keyboard", "memory", "monitor", "motherboard", "mouse"};
		double[] prices = {14000, 4500, 1200, 2000, 4000, 6000, 800};
		int id = Arrays.binarySearch(items, name);
		if(id >= 0){
			payment += 1.06 * prices[id];
			return true;
		}
		return false;
	}

	public double checkout() throws RemoteException{
		unexportObject(this, false);
		return payment;
	}
}

