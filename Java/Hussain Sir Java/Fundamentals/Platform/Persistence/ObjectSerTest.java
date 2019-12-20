import hr.*;
import java.io.*;

class ObjectSerTest{

	public static void main(String[] args) throws Exception{
		if(args.length > 0){
			Department dept = new Department();
			dept.setTitle(args[0]);
			dept.addEmployee(4, 43000);
			dept.addEmployee(6, 65000);
			dept.addEmployee(3, 34000);
			dept.addEmployee(5, 46000);
			dept.addEmployee(2, 21000);
			ObjectOutputStream output = new ObjectOutputStream(
				new FileOutputStream("dept.dat"));
			output.writeObject(dept);
			output.close();
		}else{
			ObjectInputStream input = new ObjectInputStream(
				new FileInputStream("dept.dat"));
			Department dept = (Department)input.readObject();
			input.close();
			System.out.printf("Employees of %s department%n", dept.getTitle());
			for(Employee emp : dept.getEmployees())
				System.out.println(emp);
		}
	}
}

