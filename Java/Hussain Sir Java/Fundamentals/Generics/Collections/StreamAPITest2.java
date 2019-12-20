import java.util.*;

class StreamAPITest2{

	public static void main(String[] args){
		int limit = args.length > 0 ? Integer.parseInt(args[0]) : 0;
		double distance = 500;
		List<Interval> store = new ArrayList<>();
		store.add(new Interval(4, 31));
		store.add(new Interval(7, 42));
		store.add(new Interval(6, 53));
		store.add(new Interval(3, 24));
		store.add(new Interval(5, 15));
		store.stream()
			.filter(i -> i.time() > limit)
			.sorted()
			.map(i -> String.format("%s\t%.1f", i, 3.6 * distance / i.time()))
			.forEach(System.out::println);

	}
}

