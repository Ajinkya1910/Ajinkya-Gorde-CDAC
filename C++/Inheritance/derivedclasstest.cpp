#include "payroll1.h"
#include <iostream>

using namespace Payroll;
using namespace std;

double Tax(const Employee& emp)
{
	double i = emp.Income(); //Employee::Income(&emp)
	return i > 10000 ? 0.15 * (i - 10000) : 0;
}

double Tax(const SalesPerson& emp)
{
	double i = emp.Income(); //SalesPerson::Income(&emp)
	return i > 10000 ? 0.15 * (i - 10000) : 0;
}

int main(void)
{
	Employee jack;
	jack.SetHours(186);
	jack.SetRate(52);
	cout << "Jack's Income is "
		 << jack.Income()
		 << " and Tax is "
		 << Tax(jack)
		 << endl;

	SalesPerson jill(186, 52, 68000);
	cout << "Jill's Income is "
		 << jill.Income()
		 << " and Tax is "
		 << Tax(jill)
		 << endl;
}

