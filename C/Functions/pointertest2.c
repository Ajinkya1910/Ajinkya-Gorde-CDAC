#include <stdio.h>

struct Employee
{
	int id;
	short hours;
	float rate;
	char name[32];
	char address[128];
};

typedef struct Employee Emp_t;

double EmployeeGetIncome(const Emp_t* e)
{
	double income = e->hours * e->rate;
	short ot = e->hours - 180;

	//e->id = 0;
	
	return income + 50 * ot * (ot > 0);
}

int main(void)
{
	Emp_t jack = {101, 200, 60};
	Emp_t jill = {102, 175, 84};

	printf("Jack's ID is %d and Income is %.2lf\n", jack.id, EmployeeGetIncome(&jack));
	printf("Jill's ID is %d and Income is %.2lf\n", jill.id, EmployeeGetIncome(&jill));
}

