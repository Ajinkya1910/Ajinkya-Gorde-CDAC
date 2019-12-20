interface Stack<V>{
	void push(V val);
	V pop();
	boolean empty();
}

class SimpleStack<V> implements Stack<V>{
	
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

	public void copy(Stack<? super V> target){
		for(Node n = top; n != null; n = n.below)
			target.push(n.value);
	}
}

class FiniteStack<V> implements Stack<V>{

	private int count;
	private V[] values;

	public FiniteStack(V[] store){
		values = store;
	}

	public void push(V val){
		values[count++] = val;
	}

	public V pop(){
		return values[--count];
	}

	public boolean empty(){
		return count == 0;
	}
}


class WildcardTest{

	private static void printStack(Stack<? extends Object> stack){
		for(int i = 0; !stack.empty(); ++i){
			if(i > 0) System.out.print(", ");
			System.out.print(stack.pop());
		}
		System.out.println();
	}

	public static void main(String[] args){
		SimpleStack<String> a = new SimpleStack<String>();
		a.push("Monday");
		a.push("Tuesday");
		a.push("Wednesday");
		a.push("Thursday");
		a.push("Friday");
		FiniteStack<String> b = new FiniteStack<String>(new String[16]);
		b.push("June");
		b.push("May");
		b.push("April");
		b.push("March");
		a.copy(b);
		SimpleStack<Interval> c = new SimpleStack<>();
		c.push(new Interval(5, 41));
		c.push(new Interval(6, 32));
		c.push(new Interval(4, 13));
		c.push(new Interval(7, 24));
		c.push(new Interval(3, 55));
		SimpleStack<Object> d = new SimpleStack<>();
		d.push("Sunday");
		d.push(new Interval(2, 30));
		d.push(4.56);
		c.copy(d);
		printStack(a);
		printStack(b);
		printStack(c);
		printStack(d);
	}
}

