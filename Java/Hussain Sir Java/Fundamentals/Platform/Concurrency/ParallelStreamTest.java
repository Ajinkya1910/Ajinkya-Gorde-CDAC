import java.util.stream.*;

class ParallelStreamTest{

	public static void main(String[] args) throws Exception{
		long t1 = System.currentTimeMillis();
		long r = IntStream.range(1, 21)
					.parallel()
					.mapToLong(n -> Worker.doWork(n) * n)
					.sum();
		long t2 = System.currentTimeMillis();
		System.out.printf("Computation result = %d%n", r);
		System.out.printf("Computation time = %.3f%n", (t2 - t1) / 1000.0);
	}
}

