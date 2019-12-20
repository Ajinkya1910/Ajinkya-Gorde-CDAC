import java.io.*;
import java.net.*;

class URLTest{

	public static void main(String[] args) throws Exception{
		String site = String.format("http://localhost/shop.php?item=%s", args[0]);
		URL url = new URL(site);
		try{
			InputStream input = url.openStream();
			BufferedReader reader = new BufferedReader(
				new InputStreamReader(input));
			String content = reader.readLine();
			String[] info = content.split("&");
			System.out.println(info[0]);
			System.out.println(info[1]);
			reader.close();
		}catch(FileNotFoundException e){
			System.out.println("Not available!");
		}
	}
}

