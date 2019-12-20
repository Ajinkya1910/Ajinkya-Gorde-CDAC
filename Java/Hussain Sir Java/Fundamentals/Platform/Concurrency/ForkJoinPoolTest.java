import java.util.*;
import java.util.concurrent.*;

class ForkJoinPoolTest{
	
	static class Computation extends RecursiveTask<Long>{

		private int low, high;

		public Computation(int l, int h){
			low = l;
			high = h;
		}

		public Long compute(){
			if(high - low > 3){
				int mid = (low + high) / 2;
				Computation left = new Computation(low, mid);
				Computation right = new Computation(mid + 1, high);
				right.fork();
				return left.compute() + right.join();
			}
			long result = 0;
			for(int value = low; value <= high; ++value){
				result += Worker.doWork(value) * value;
			}
			return result;
		}

	}

	public static void main(String[] args) throws Exception{
		ForkJoinPool pool = new ForkJoinPool();
		Computation c = new Computation(1, 20);
		long t1 = System.currentTimeMillis();
		long r = pool.invoke(c);
		long t2 = System.currentTimeMillis();
		System.out.printf("Computation result = %d%n", r);
		System.out.printf("Computation time = %.3f%n", (t2 - t1) / 1000.0);
	}
}
