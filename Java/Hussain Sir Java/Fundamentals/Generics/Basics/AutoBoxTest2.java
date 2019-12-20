class AutoBoxTest2{

	private static Object select(int sign, Object first, Object second){
		if(sign < 0)
			return first;
		return second;
	}

	public static void main(String[] args){
		int s = Integer.parseInt(args[0]);
		String ss = (String)select(s, "Monday", "Tuesday");
		System.out.printf("Selected String = %s%n", ss);
		double sd = (double)select(s, 43.2, 34.5); //automatic boxing(argument type) and unboxing(return type)
		System.out.printf("Selected double = %s%n", sd);
		int si = (int)select(s, 1234, "abcd");
		System.out.printf("Selected int = %s%n", si);
	}
}

