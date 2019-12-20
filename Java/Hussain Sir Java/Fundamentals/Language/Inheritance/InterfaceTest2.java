interface Consumer extends AutoCloseable{

	int LIMIT = 10;

	void apply(int action);

	default void applyAll(int first, int last){
		for(int act = first; act <= last; ++act)
			apply(act);
	}
}

class ResourceConsumer implements Consumer{

	private String id;

	public ResourceConsumer(String name){
		id = name;
		System.out.printf("%s resource acquired%n", id);
	}

	public void apply(int action){
		if(id != null)
			System.out.printf("%s resource consumed using action<%d>%n", id, action);
	}

	public void close(){
		System.out.printf("%s resource released%n", id);
		id = null;
	}

}

class InterfaceTest2{

	private static void run(String op){
		try(var b = new ResourceConsumer("Second")){
			int n = Integer.parseInt(op);
			b.applyAll(1, n);
		}
	}

	public static void main(String[] args){
		var a = new ResourceConsumer("First");
		a.apply(1);
		a.close();
		try{
			run(args[0]);
		}catch(Throwable t){}
	}
}

