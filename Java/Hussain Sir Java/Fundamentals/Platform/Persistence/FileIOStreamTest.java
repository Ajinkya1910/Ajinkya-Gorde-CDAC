import java.io.*;

class FileIOStreamTest{

	public static void main(String[] args) throws Exception{
		try(InputStream source = new FileInputStream(args[0])){
			try(OutputStream target = new FileOutputStream(args[1])){
				byte[] buffer = new byte[80];
				while(source.available() > 0){
					int n = source.read(buffer, 0, buffer.length);
					for(int i = 0; i < n; ++i)
						buffer[i] = (byte)(buffer[i] ^ '#');
					target.write(buffer, 0, n);
				}
			}
		}
	}
}

