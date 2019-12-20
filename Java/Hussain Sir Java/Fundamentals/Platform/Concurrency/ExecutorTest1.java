import java.util.*;
import java.util.concurrent.*;

class ExecutorTest1{
	
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
		ExecutorService pool = Executors.newFixedThreadPool(2);
		System.out.print("Limit (1/2): ");
		int m = input.nextInt();
		Computation c1 = new Computation(1, m);
		Future<Long> r1 = pool.submit(c1);
		//long r1 = c1.call();
		System.out.print("Limit (2/2): ");
		int n = input.nextInt();
		Computation c2 = new Computation(m + 1, n);
		Future<Long> r2 = pool.submit(c2);
		//long r2 = c2.call();
		//long r = r1 + r2;
		long r = r1.get() + r2.get();
		System.out.printf("Computation result = %d%n", r);
		pool.shutdown();
	}
}
