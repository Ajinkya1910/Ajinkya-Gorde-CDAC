#include <stdio.h>

struct Employee
{
	int id;
	short hours;
	float rate;
};

typedef struct Employee Emp_t;

typedef struct Manager
{
	int id;
	short hours;
	float rate;
	int sid;
}Mgr_t;

double EmployeeGetIncome(const Emp_t* e)
{
	double income = e->hours * e->rate;
	short ot = e->hours - 180;

	return income + 50 * ot * (ot > 0);
}

/*
double ManagerGetIncome(const Mgr_t* e)
{
	double income = e->hours * e->rate;
	short ot = e->hours - 180;

	return income + 50 * ot * (ot > 0);
}
*/

int main(void)
{
	Emp_t jack = {101, 200, 60};
	Mgr_t jill = {102, 175, 240, 101};

	printf("Jack's ID is %d and Income is %.2lf\n", jack.id, EmployeeGetIncome(&jack));
	//printf("Jill's ID is %d and Income is %.2lf\n", jill.id, ManagerGetIncome(&jill));
	printf("Jill's ID is %d and Income is %.2lf\n", jill.id, EmployeeGetIncome((Emp_t*)&jill));
}

