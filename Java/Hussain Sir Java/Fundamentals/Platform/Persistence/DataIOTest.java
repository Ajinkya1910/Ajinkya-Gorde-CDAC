import java.io.*;

class DataIOTest{

	public static void main(String[] args) throws Exception{
		if(args.length > 2){
			String item = args[0];
			float price = Float.parseFloat(args[1]);
			short stock = Short.parseShort(args[2]);
			DataOutputStream output = new DataOutputStream(
				new FileOutputStream("product.dat"));
			output.writeFloat(price);
			output.writeShort(stock);
			output.writeUTF(item);
			output.close();
		}else{
			DataInputStream input = new DataInputStream(
				new FileInputStream("product.dat"));
			float price = input.readFloat();
			short stock = input.readShort();
			String item = input.readUTF();
			input.close();
			System.out.printf("%s %s %s%n", item, price, stock);
		}
	}
}

