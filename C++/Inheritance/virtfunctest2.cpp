#define _TESTING
#include "payroll2.h"
#include <iostream>

using namespace Payroll;
using namespace std;

double GetAverageIncome(Employee* group[], int count)
{
	double total = 0;

	for(int i = 0; i < count; ++i)
	{
		total += group[i]->Income();
	}

	return total / count;
}

int main(void)
{
	Employee* department[5];
	department[0] = new Employee(186, 52);
	cout << "-----------------------------" << endl;
	department[1] = new Employee(175, 250);
	cout << "-----------------------------" << endl;
	department[2] = new SalesPerson(168, 48, 38000); //implicit upcasting
	cout << "-----------------------------" << endl;
	department[3] = new Employee(190, 80);
	cout << "-----------------------------" << endl;
	department[4] = new SalesPerson(202, 52, 62000);

	cout << "Average Income = "
		 << GetAverageIncome(department, 5)
		 << endl;

	for(int i = 0; i < 5; ++i)
	{
		cout << "-----------------------------" << endl;
		delete department[i];
	}
}

