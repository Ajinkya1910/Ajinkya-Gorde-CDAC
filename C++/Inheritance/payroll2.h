#ifndef PAYROLL2_H
#define PAYROLL2_H

#include <iostream>

namespace Payroll
{
	class Employee
	{
	public:
		explicit Employee(short h=0, float r=40)
		{
			hours = h;
			rate = r;
			#ifdef _TESTING
			std::cout << "Employee object activated" << std::endl;
			#endif
		}

		int GetHours() const
		{	
			return hours;
		}

		void SetHours(short value)
		{
			hours = value;
		}

		virtual float GetRate() const
		{
			return rate;
		}

		void SetRate(float value)
		{
			rate = value;
		}

		//overridable member function
		virtual double Income() const
		{
			double income = hours * rate;
			short ot = hours - 180;

			return income + 50 * ot * (ot > 0);
		}

		virtual ~Employee()
		{
			#ifdef _TESTING
			std::cout << "Employee object deactivated" << std::endl;
			#endif
		}
	private:
		short hours;
		float rate;
	};

	class SalesPerson : public Employee
	{
	public:
		SalesPerson(short h, float r, double s) : Employee(h, r)
		{
			sales = s;
			#ifdef _TESTING
			std::cout << "SalesPerson object activated" << std::endl;
			#endif
		}

		virtual double GetSales() const
		{
			return sales;
		}

		//overriding member function of base class
		double Income() const 
		{
			double income = Employee::Income();
			
			if(sales >= 20000)
				income += 0.05 * sales;

			return income;
		}

		~SalesPerson()
		{
			#ifdef _TESTING
			std::cout << "SalesPerson object deactivated" << std::endl;
			#endif
		}
	private:
		double sales;
	};
}

#endif

