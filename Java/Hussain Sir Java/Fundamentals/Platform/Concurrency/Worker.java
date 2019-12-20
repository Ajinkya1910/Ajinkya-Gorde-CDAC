class Worker{

	public static int doWork(int count){
		long t = System.currentTimeMillis();
		if(count <= 0)
			count = (int)(t % 10 + 1);
		while(System.currentTimeMillis() < t + 100 * count);
		return count;
	}

	public static int doWork(){
		return doWork(0);
	}
}





