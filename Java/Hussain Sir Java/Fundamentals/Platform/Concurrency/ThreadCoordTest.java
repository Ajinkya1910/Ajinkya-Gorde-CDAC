class ThreadCoordTest{

	private volatile static int value = 0;
	private static Object coordinator = new Object();

	private static void consume(){
		System.out.printf("Consumer<%x> ready...%n", Thread.currentThread().hashCode());
		//while(value == 0) Thread.yield();
		synchronized(coordinator){
			try{
				coordinator.wait();
			}catch(InterruptedException e){}
			System.out.printf("Processed value = %d%n", value * value);
		}
	}

	private static void produce(){
		System.out.printf("Producer<%x> ready...%n", Thread.currentThread().hashCode());
		int result = Worker.doWork();
		synchronized(coordinator){
			value = result;
			coordinator.notify();
		}
	}

	public static void main(String[] args) throws Exception{
		Thread producer = new Thread(ThreadCoordTest::produce);
		producer.start();
		Thread consumer = new Thread(ThreadCoordTest::consume);
		consumer.start();
	}
}












