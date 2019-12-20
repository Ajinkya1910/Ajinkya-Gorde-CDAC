#include "payroll3.h"
#include <iostream>

using namespace Payroll;
using namespace std;

void Print(const Employee* emp)
{
	cout << "Income of Employee with ID "
		 << emp->GetId()
		 << " is "
		 << emp->Income()
		 << endl;
}

int main(void)
{
	Employee* jack = new Employee(186, 52);
	Employee* jill = new Employee(175, 95);

	Employee* jeff = const_cast<Employee*>(Employee::GetManager());
	jeff->SetRate(600);
	struct _Employee
	{
		void* vt;
		short hours;
		float rate;
		int id;
	};
	_Employee* _jeff = reinterpret_cast<_Employee*>(jeff);
	_jeff->id = 10;

	Print(jack);
	Print(jill);
	Print(jeff);

	delete jill;
	delete jack;
}

