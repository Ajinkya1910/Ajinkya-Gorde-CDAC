import java.util.*;

class HashMapTest{
	
	public static void main(String[] args){
		Map<String, Interval> store = new HashMap<>();
		store.put("monday", new Interval(4, 31));
		store.put("tuesday", new Interval(5, 12));
		store.put("wednesday", new Interval(7, 23));
		store.put("thursday", new Interval(3, 44 ));
		store.put("friday", new Interval(6, 55));
		store.put("monday", new Interval(2, 31));
		if(args.length > 0){
			Interval val = store.get(args[0]);
			if(val != null)
				System.out.printf("Value = %s%n", val);
			else
				System.out.println("No such key!");
		}else{
			for(var e : store.entrySet())
				System.out.printf("%s\t%s%n", e.getValue(), e.getKey());
		}
	}
}

