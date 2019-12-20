class ClassTest{

	private static float speed(float distance, Interval duration){
		return 3.6f * distance / duration.time();
	}

	public static void main(String[] args){
		Interval jack = new Interval(2, 5);
		System.out.print("Jack's Interval = ");
		jack.print();
		System.out.printf("Jack's speed = %.1f%n", speed(500, jack));
		var john = new Interval(2, 80);
		System.out.print("John's Interval = ");
		john.print();
		System.out.printf("John's speed = %.1f%n", speed(500, john));
	}
}

