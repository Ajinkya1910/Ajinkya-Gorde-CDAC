import java.util.*;

class TreeSetTest{
	
	public static void main(String[] args){
		//Set<Interval> store = new TreeSet<>();
		Set<Interval> store = new TreeSet<>((x, y) -> x.seconds() - y.seconds());
		store.add(new Interval(4, 31));
		store.add(new Interval(5, 12));
		store.add(new Interval(7, 23));
		store.add(new Interval(3, 44 ));
		store.add(new Interval(6, 55));
		for(Interval i : store)
			System.out.println(i);
	}
}

