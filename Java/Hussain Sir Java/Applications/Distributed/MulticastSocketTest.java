import java.net.*;

class MulticastSocketTest{

	public static void main(String[] args) throws Exception{
		InetAddress addr = InetAddress.getByName("230.0.0.1");
		MulticastSocket subscriber = new MulticastSocket(4002);
		subscriber.joinGroup(addr);
		DatagramPacket packet = new DatagramPacket(new byte[65507], 65507);
		for(int i = 0; i < 5; ++i){
			subscriber.receive(packet);
			String message = new String(packet.getData(), 0, packet.getLength());
			System.out.println(message);
		}
		subscriber.leaveGroup(addr);
		subscriber.close();
	}
}

