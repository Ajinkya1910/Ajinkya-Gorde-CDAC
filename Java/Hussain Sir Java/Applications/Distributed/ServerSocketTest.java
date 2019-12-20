import java.io.*;
import java.util.*;
import java.net.*;

class ServerSocketTest{

	public static void main(String[] args) throws Exception{
		ServerSocket listener = new ServerSocket(4001);
		for(int i = 0; i < 3; ++i){
			Thread servant = new Thread(() -> 
			{
				try{
					service(listener);
				}catch(IOException e){}
			});
			servant.start();
		}
	}

	private static void service(ServerSocket server) throws IOException{
		String[] items = {"cpu", "hdd", "keyboard", "memory", "monitor", "motherboard", "mouse"};
		double[] prices = {14000, 4500, 1200, 2000, 4000, 6000, 800};
		int[] stocks = {200, 300, 500, 550, 450, 350, 150};
		for(;;){
			Socket client = server.accept();
			client.setSoTimeout(20000);
			InputStream input = client.getInputStream();
			OutputStream output = client.getOutputStream();
			BufferedReader reader = new BufferedReader(
				new InputStreamReader(input));
			PrintWriter writer = new PrintWriter(
				new OutputStreamWriter(output), true);
			try{
				writer.println("Welcome to our shop");
				String item = reader.readLine();
				int i = Arrays.binarySearch(items, item);
				if(i >= 0)
					writer.printf("price=%s&stock=%s%n", prices[i], stocks[i]);
				else
					writer.println();
			}catch(Exception e){}
			writer.close();
			reader.close();
			client.close();
		}

	}
}

