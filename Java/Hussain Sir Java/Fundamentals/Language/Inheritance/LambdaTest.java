//functional interface - defines exactly one abstract method 
interface Filter{
	boolean allowed(int value);
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

class LambdaTest{

	private static boolean isOdd(int n){
		return (n % 2) == 1;
	}

	public static void main(String[] args){
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Squares.print("All", numbers);
		//passing a method-reference (an implementation of Filter will be produced
		//at runtime which will will invoke the referred method)
		Squares.printSelected("Odd", numbers, LambdaTest::isOdd);
		//passing a lambda expression: (arguments) -> expression
		Squares.printSelected("Big", numbers, n -> n > 6);
	}
}

