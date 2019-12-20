import finance.*;
import java.lang.reflect.*;

class AnnotationTest{

	public static void main(String[] args) throws Exception{
		double p = Double.parseDouble(args[0]);
		Class<?> c = Class.forName(args[1]);
		Method meth = c.getMethod(args[2], double.class, int.class);
		Object pol = c.getDeclaredConstructor().newInstance();
		int m = 10;
		if(c.isAnnotationPresent(MaxDuration.class)){
			MaxDuration md = c.getAnnotation(MaxDuration.class);
			m = md.value();
		}
		for(int n = 1; n <= m; ++n){
			float r = (float)meth.invoke(pol, p, n);
			float i = r / 1200;
			double emi = p * i / (1 - Math.pow(1 + i, -12 * n));
			System.out.printf("%d\t%.2f%n", n, emi);
		}
	}
}


