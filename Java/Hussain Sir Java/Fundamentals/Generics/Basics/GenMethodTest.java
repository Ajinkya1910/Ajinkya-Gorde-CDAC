class GenMethodTest{

	private static<T> T select(int sign, T first, T second){
		if(sign < 0)
			return first;
		return second;
	}

	public static void main(String[] args){
		int s = Integer.parseInt(args[0]);
		String ss = select(s, "Monday", "Tuesday");
		System.out.printf("Selected String = %s%n", ss);
		double sd = select(s, 43.2, 34.5); //automatic boxing(argument type) and unboxing(return type)
		System.out.printf("Selected double = %s%n", sd);
		int si = select(s, 1234, 0xabcd);
		System.out.printf("Selected int = %s%n", si);
	}
}

