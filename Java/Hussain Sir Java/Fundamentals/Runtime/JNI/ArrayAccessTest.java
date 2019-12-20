class ArrayHelper{

	public native static int squareAll(double[] values);

	static{
		System.loadLibrary("arrh");
	}
}

class ArrayAccessTest{

	public static void main(String[] args){
		double[] list = new double[args.length];
		for(int i = 0; i < list.length; ++i)
			list[i] = Double.parseDouble(args[i]);
		ArrayHelper.squareAll(list);
		for(double v : list)
			System.out.printf("%.4f%n", v);
	}
}

