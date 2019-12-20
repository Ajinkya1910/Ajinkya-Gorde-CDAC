import payroll.*;

class SubclassTest2{

	private static double averageIncome(Employee[] group){
		double total = 0;
		for(Employee member : group){
			total += member.getIncome();
		}
		return total / group.length;
	}

	private static double totalSales(Employee[] group){
		double total = 0;
		for(Employee member : group){
			if(member instanceof SalesPerson){
				SalesPerson sp = (SalesPerson)member;
				total += sp.getSales();
			}
		}
		return total;
	}

	public static void main(String[] args){
		Employee[] department = new Employee[5];
		department[0] = new Employee(186, 52);
		department[1] = new Employee(175, 75);
		department[2] = new SalesPerson(160, 40, 35000);
		department[3] = new Employee(195, 210);
		department[4] = new SalesPerson(190, 60, 65000);
		System.out.printf("Average income = %.2f%n", averageIncome(department));
		System.out.printf("Total sales = %.2f%n", totalSales(department));
	}
}

