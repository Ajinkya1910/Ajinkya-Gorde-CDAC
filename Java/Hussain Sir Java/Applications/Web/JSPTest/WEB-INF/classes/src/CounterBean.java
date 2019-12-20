package basic.web.app;

public class CounterBean implements java.io.Serializable{

	private long count = 0;
	private int step = 1;

	public final int getStep(){return step;}
	public final void setStep(int value){step = value;}

	public synchronized long getNextCount(){
		return count += step;
	}
}


