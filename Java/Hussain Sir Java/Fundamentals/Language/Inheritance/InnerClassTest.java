//functional interface - defines exactly one abstract method 
interface Filter{
	boolean allowed(int vallue);
}

class Squares{

	public static void print(String prefix, int[] values){
		System.out.printf("%s squares:", prefix);
		for(int value : values){
			System.out.printf(" %d", value * value);
		}
		System.out.println();
	}

	public static void printSelected(String prefix, int[] values, Filter check){
		System.out.printf("%s squares:", prefix);
		for(int value : values){
			if(check.allowed(value))
				System.out.printf(" %d", value * value);
		}
		System.out.println();
	}
}

class InnerClassTest{

	//inner nested(static) member class
	//can only refer to static members of outer class
	//can define static as well as non-static members
	static class OddFilter implements Filter{
		public boolean allowed(int n){
			return (n % 2) == 1;
		}
	}

	//inner member class
	//can refer to static as well as non-static members of outer class
	//can only define non-static members
	class BigFilter implements Filter{
		private int minimum;

		public BigFilter(int min){
			minimum = min;
		}

		public boolean allowed(int n){
			return n > minimum;
		}
	}

	public static void main(String[] args){
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Squares.print("All", numbers);
		Squares.printSelected("Odd", numbers, new InnerClassTest.OddFilter());
		Squares.printSelected("Big", numbers, new InnerClassTest().new BigFilter(6));
		int max = 5; //effectively final since it is accessed in the inner class of this method
		//passing instance of inner local anonymous class
		Squares.printSelected("Small", numbers, new Filter(){
			public boolean allowed(int n){
				return n < max;
			}
		});
	}
}

