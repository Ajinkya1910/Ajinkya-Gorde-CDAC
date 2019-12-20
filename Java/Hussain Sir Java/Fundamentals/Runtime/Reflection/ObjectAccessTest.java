import java.lang.reflect.*;

class ObjectAccessTest{

	private static void printAsXml(Object obj){
		Class<?> c = obj.getClass();
		System.out.printf("<%s>%n", c.getSimpleName());
		for(Field f : c.getDeclaredFields()){
			int m = f.getModifiers();
			if(Modifier.isStatic(m)) continue;
			System.out.printf("  <%s>", f.getName());
			try{
				f.setAccessible(true);
				System.out.print(f.get(obj));
			}catch(Exception e){
				System.out.print(e);
			}
			System.out.printf("</%s>%n", f.getName());
		}
		System.out.printf("</%s>%n", c.getSimpleName());
		System.out.println();
	}

	public static void main(String[] args){
		printAsXml(new Interval(3, 45));
		printAsXml(new payroll.Employee(186, 52));
	}
}


