import java.util.*;
import java.util.concurrent.*;

class ExecutorTest2{
	
	static class Computation implements Callable<Long>{

		private int low, high;

		public Computation(int l, int h){
			low = l;
			high = h;
		}

		public Long call(){
			long result = 0;
			for(int value = low; value <= high; ++value)
				result += Worker.doWork(value) * value;
			return result;
		}

	}

	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(System.in);
		ExecutorService pool = Executors.newSingleThreadExecutor();
		System.out.print("Limit: ");
		int m = input.nextInt();
		Computation c = new Computation(1, m);
		System.out.print("Computing...");
		var r = pool.submit(c);
		while(!r.isDone()){
			System.out.print(".");
			Thread.sleep(500);
		}
		System.out.println("Done!");
		System.out.printf("Computation result = %d%n", r.get());
		pool.shutdown();
	}
}
