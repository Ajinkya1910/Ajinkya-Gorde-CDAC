import java.io.*;

class TextIOTest{

	public static void main(String[] args) throws Exception{
		if(args.length > 2){
			String item = args[0];
			float price = Float.parseFloat(args[1]);
			short stock = Short.parseShort(args[2]);
			PrintWriter output = new PrintWriter(
				new FileWriter("product.txt"));
			output.println(price);
			output.println(stock);
			output.println(item);
			output.close();
		}else{
			BufferedReader input = new BufferedReader(
				new FileReader("product.txt"));
			float price = Float.parseFloat(input.readLine());
			short stock = Short.parseShort(input.readLine());
			String item = input.readLine();
			input.close();
			System.out.printf("%s %s %s%n", item, price, stock);
		}
	}
}

