class MethodTest2{

	private static double average(double first, double second){
		return (first + second) / 2;
	}

	private static double average(double first, double second, double third){
		return (first + second + third) / 3;
	}

	private static double average(double first, double second, double... remaining){
		double total = first + second;
		for(double value : remaining){
			total += value;
		}
		return total / (remaining.length + 2); 
	}

	public static void main(String[] args){
		System.out.printf("Average of two values = %f\n", average(21.6, 26.7));
		System.out.printf("Average of three values = %f\n", average(21.6, 26.7, 17.1));
		System.out.printf("Average of five values = %f\n", average(21.6, 26.7, 17.1, 34.3, 11.8));
	}
}

