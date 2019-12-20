#include <stdio.h>

double Average(double first, double second, double* deviation)
{
	*deviation = first > second ? (first - second) / 2 : (second - first) / 2;
	return (first + second) / 2;
}

int main(void)
{
	double a = 1.2, b = 2.3, c = 3.4, d = 4.5;
	/*
	double* pa = &a;
	double* pd = pa + 3;

	printf("Pointer %p points to value %lf\n", pa, *pa);
	printf("Pointer %p points to value %lf\n", pd, *pd);
	*/

	printf("Enter two real values: ");
	scanf("%lf%lf", &b, &c);

	a = Average(b, c, &d);

	printf("Average is %lf with a deviation of %lf\n", a, d);	
}


