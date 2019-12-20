class StringHelper{

	public native static String reverseOf(String str);

	static{
		System.loadLibrary("strh");
	}
}

class StringAccessTest{

	public static void main(String[] args){
		System.out.printf("Original String  : %s%n", args[0]);
		System.out.printf("Reverse of String: %s%n", StringHelper.reverseOf(args[0]));
	}
}

