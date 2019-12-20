class TryFinallyTest{
	
	private static void run(String args[]){
		System.out.println("run - acquiring resources");	
		try{
			float value = Float.parseFloat(args[0]);
			System.out.printf("Square of %f is %f%n", value, value * value);
		}finally{
			System.out.println("run - releasing resources");	
		}
	}

	public static void main(String[] args){
		System.out.println("Welcome User");
		try{
			run(args);
		}catch(Exception e){
			System.out.printf("ERROR: %s%n", e.getMessage());
		}
		System.out.println("Goodbye User");
	}
}

