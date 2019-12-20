import java.io.*;
import java.nio.*;
import java.nio.channels.*;

class FileChannelTest{

	public static void main(String[] args) throws Exception{
		try(var file = new RandomAccessFile(args[0], "rw")){
			int n = (int)file.length();
			FileChannel channel = file.getChannel();
			FileLock lock = channel.lock();
			ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, n);
			for(int i = 0, j = n - 1; i < j; ++i, j--){
				byte ib = buffer.get(i);
				byte jb = buffer.get(j);
				buffer.put(i, jb);
				buffer.put(j, ib);
			}
			lock.release();
			channel.close();
		}
	}
}


