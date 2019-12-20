package payroll;

public class Employee{

	private int id;
	private int hours;
	protected float rate;
	static int count;

	public Employee(int h, float r){
		id = 501 + count++;
		hours = h;
		rate = r;
	}

	public Employee(){
		this(0, 40);
	}

	public int getId(){return id;}

	public int getHours(){return hours;}
	public void setHours(int value){hours = value;}

	public float getRate(){return rate;}
	public void setRate(float value){rate = value;}

	public double getIncome(){
		double income = hours * rate;
		int ot = hours - 180;
		if(ot > 0)
			income += 50 * ot;
		return income;
	}

	public static int countInstances(){
		return count;
	}

}

