import java.util.*;
import java.net.*;

class DatagramSocketTest{

	public static void main(String[] args) throws Exception{
		String[] symbols = {"APPL", "GOGL", "INTC", "MSFT", "ORCL"};
		Random rdm = new Random();
		DatagramSocket publisher = new DatagramSocket();
		InetAddress group = InetAddress.getByName("230.0.0.1");
		for(;;){
			int i = rdm.nextInt(symbols.length);
			double price = 0.01 * (1000 + rdm.nextInt(9000));
			String message = String.format("%s : %.2f", symbols[i], price);
			DatagramPacket packet = new DatagramPacket(message.getBytes(), message.length(), group, 4002);
			publisher.send(packet);
			Thread.sleep(10000);
		}
	}
}

