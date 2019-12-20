package hr;

import java.util.*;

public class Department implements java.io.Serializable{

	private String title = null;
	private List<Employee> employees = new ArrayList<Employee>();

	public final String getTitle(){
		return title;
	}

	public final void setTitle(String value){
		title = value;
	}

	public final List<Employee> getEmployees(){
		return employees;
	}

	public final void setEmployees(List<Employee> value){
		employees = value;
	}

	public Employee addEmployee(int exp, double sal){
		Employee emp = new Employee();
		int i = 501 + employees.size();
		emp.setCode(title.substring(0, 3).toUpperCase() + i);
		emp.setPassword("PWD" + i);
		emp.setExperience(exp);
		emp.setSalary(sal);
		employees.add(emp);
		return emp;
	}
}














