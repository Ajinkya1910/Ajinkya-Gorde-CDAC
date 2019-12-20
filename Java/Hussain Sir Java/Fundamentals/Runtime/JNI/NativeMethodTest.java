class NativeMethodTest{
	
	private native static int gcd(int first, int second);

	public static void main(String[] args){
		System.loadLibrary("nmt");
		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		System.out.printf("G.C.D = %d%n", gcd(m, n));
	}
}

