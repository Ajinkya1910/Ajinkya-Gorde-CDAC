#include <stdio.h>
/*
void SwapInt(int* first, int* second)
{
	int third = *first;
	*first = *second;
	*second = third;
}

void SwapDouble(double* first, double* second)
{
	double third = *first;
	*first = *second;
	*second = third;
}
*/

void SwapAny(void* first, void* second, unsigned long sz)
{
	char* pf = first;
	char* ps = second;
	register int i;

	for(i = 0; i < sz; ++i)
	{
		char t = pf[i];
		pf[i] = ps[i];
		ps[i] = t;
	}

}

#define Swap(X, Y) SwapAny(&X, &Y, sizeof(X))

int main(void)
{
	int ix = 23, iy = 24;
	double dx = 3.4, dy = 4.5;

	printf("Original int values = %d, %d\n", ix, iy);
	//SwapInt(&ix, &iy);
	Swap(ix, iy);
	printf("Swapped int values = %d, %d\n", ix, iy);

	printf("Original double values = %lf, %lf\n", dx, dy);
	//SwapDouble(&dx, &dy);
	Swap(dx, dy);
	printf("Swapped double values = %lf, %lf\n", dx, dy);
}

