[assembly:System.Reflection.AssemblyVersion("1.0.0.0")]
namespace Payroll
{
	public class Employee
	{
		internal static int count;

		public int Id {get;}
		
		public int Hours {get; set;}

		public float Rate {get; set;}

		public int Age {get; set;} = 25;

		public Employee(int hours, float rate)
		{
			Id = 101 + count++;
			Hours = hours;
			Rate = rate;
		}

		public Employee() : this(0, 40) {}

		//overridable method
		public virtual double GetIncome()
		{
			double income = Hours * Rate;
			int ot = Hours - 180;

			if(ot > 0)
				income += 50 * ot;

			return income;
		}		

		public static int CountInstances()
		{
			return count;
		}

	}

	public  class SalesPerson : Employee
	{
		public double Sales {get;}

		public SalesPerson(int hours, float rate, double sales) : base(hours, rate)
		{
			Sales = sales;
		}

		//public new double GetIncome() //hiding (by signature) method of base class
		public override double GetIncome() //overriding method of base class
		{
			double income = base.GetIncome();
			
			if(Sales >= 20000)
				income += 0.05 * Sales;

			return income;
		}
	}
}
