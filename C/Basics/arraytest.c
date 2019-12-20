#include <stdio.h>


int main(void)
{
	double squares[] = {0.01, 0.04, 0.09, 0.16, 0.25, 0.36, 0.49, 0.64, 0.81};
	int index;
	double value;

	printf("Index [0-8]: ");
	scanf("%d", &index);
	
	value = squares[index];

	printf("Value = %lf\n", value);

}


