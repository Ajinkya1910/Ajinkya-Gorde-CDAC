package hr;

public class Employee implements java.io.Serializable{

	private String code;
	private transient String password;
	private int experience;
	private double salary;

	public final String getCode(){
		return code;
	}

	public final void setCode(String value){
		code = value;
	}
	
	public final String getPassword(){
		return password;
	}

	public final void setPassword(String value){
		password = value;
	}

	public final int getExperience(){
		return experience;
	}

	public final void setExperience(int value){
		experience = value;
	}

	public final double getSalary(){
		return salary;
	}

	public final void setSalary(double value){
		salary = value;
	}

	@Override
	public String toString(){
		return String.format("%s\t%d\t%.2f\t%s", code, experience, salary, 
			password);
	}
	
}




















