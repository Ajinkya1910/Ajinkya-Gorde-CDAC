#ifndef PAYROLL3_H
#define PAYROLL3_H

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
			id = 0;
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
	
		int GetId() const
		{
			static int nid = 1;
			if(id == 0)
				id = ++nid;
			return id;
		}

		static const Employee* GetManager()
		{
			static Employee mgr(180, 500);
			mgr.id = 1;
			return &mgr;
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
		mutable int id; //value can be modified even in a const member function
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

