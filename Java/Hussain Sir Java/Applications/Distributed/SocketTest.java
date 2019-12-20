import java.io.*;
import java.net.*;

class SocketTest{

	public static void main(String[] args) throws Exception{
		String item = args[0].toLowerCase();
		String host = args.length > 1 ? args[1] : "localhost";
		Socket client = new Socket(host, 4001);
		InputStream input = client.getInputStream();
		OutputStream output = client.getOutputStream();
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(input));
		PrintWriter writer = new PrintWriter(
			new OutputStreamWriter(output));
		System.out.println(reader.readLine());
		writer.println(item);
		writer.flush();
		String response = reader.readLine();
		if(response.length() > 0){
			String[] info = response.split("&");
			System.out.println(info[0]);
			System.out.println(info[1]);
		}else{
			System.out.println("Not available!");
		}
	}
}


