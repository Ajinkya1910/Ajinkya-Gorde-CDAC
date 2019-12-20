class TryCatchTest{
	
	private static void run(String args[]){
		try{
			float value = Float.parseFloat(args[0]);
			System.out.printf("Square of %f is %f%n", value, value * value);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("No input!");
		}catch(NumberFormatException e){
			System.out.println("Bad input!");
		}
	}

	public static void main(String[] args){
		System.out.println("Welcome User");
		run(args);
		System.out.println("Goodbye User");
	}
}

