import java.util.*;

class HashSetTest{
	
	public static void main(String[] args){
		Set<Interval> store = new HashSet<>();
		store.add(new Interval(4, 31));
		store.add(new Interval(5, 12));
		store.add(new Interval(7, 23));
		store.add(new Interval(3, 44 ));
		store.add(new Interval(6, 55));
		store.add(new Interval(2, 151));
		for(Interval i : store)
			System.out.println(i);
	}
}

