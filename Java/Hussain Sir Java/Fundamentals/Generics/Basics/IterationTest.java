import java.util.Iterator;

class SimpleStack<V> implements Iterable<V>{
	
	private Node top;

	class Node{
		V value;
		Node below;

		Node(V val){
			value = val;
			below = top;
		}
	}

	public void push(V val){
		top = new Node(val);
	}

	public V pop(){
		Node node = top;
		top = top.below;
		return node.value;
	}

	public boolean empty(){
		return top == null;
	}

	public Iterator<V> iterator(){
		return new Iterator<V>(){
			Node current = top;

			public boolean hasNext(){
				return current != null;
			}

			public V next(){
				V val = current.value;
				current = current.below;
				return val;
			}

		};
	}
}

class IterationTest{

	public static void main(String[] args){
		int[] numbers = {1, 2, 3, 4, 5, 6};
		System.out.println("All integers in array");
		for(int n : numbers)
			System.out.println(n);
		SimpleStack<String> days = new SimpleStack<>();
		days.push("Monday");
		days.push("Tuesday");
		days.push("Wednesday");
		days.push("Thursday");
		days.push("Friday");
		System.out.println("All strings on stack");
		for(String d : days)
			System.out.println(d);
	}
}

