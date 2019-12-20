class SimpleStack<V>{
	
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
}

class GenClassTest{

	public static void main(String[] args){
		SimpleStack<String> a = new SimpleStack<String>();
		a.push("Monday");
		a.push("Tuesday");
		a.push("Wednesday");
		a.push("Thursday");
		a.push("Friday");
		SimpleStack<String> b = new SimpleStack<String>();
		b.push("June");
		b.push("May");
		b.push("April");
		b.push("March");
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
		while(!a.empty())
			System.out.println(a.pop());
		System.out.println("---------------------");
		while(!b.empty())
			System.out.println(b.pop());
		System.out.println("---------------------");
		while(!c.empty())
			System.out.println(c.pop());
		System.out.println("---------------------");
		while(!d.empty())
			System.out.println(d.pop());
	}
}

