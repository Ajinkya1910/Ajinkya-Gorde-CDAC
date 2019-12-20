public interface Greeter{
	String meet(String name, boolean formal);
	String leave(String name);
}

class EnglishGreeter implements Greeter{

	public String meet(String name, boolean formal){
		if(formal)
			return "Hello " + name;
		return "Hi " + name;
	}

	public String leave(String name){
		return "Bye " + name;
	}
}


