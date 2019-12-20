import java.util.*;
import java.lang.reflect.*;
import java.net.*;

class ClassLoaderTest{
	
	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		URL[] locations = {new URL("file:./CMD-INF/")};
		for(;;){
			System.out.print("COMMAND: ");
			String cmd = input.nextLine();
			if(cmd.length() == 0) continue;
			if(cmd.equals("Quit")) break;
			try{
				ClassLoader loader = new URLClassLoader(locations);
				Class<?> c = Class.forName("commands." + cmd, true, loader);
				Method m = c.getMethod("execute", String.class);
				m.invoke(null, "ClassLoaderTest");
			}catch(Exception e){
				System.out.printf("ERROR: %s%n", e);
			}
			System.out.println();
		}
	}
}

