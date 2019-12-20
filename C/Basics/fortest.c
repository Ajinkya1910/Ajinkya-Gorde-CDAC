#include <stdio.h>

int main(void)
{
	int first, last;
	int result = 0;
	register int value;

	printf("Enter first and last numbers: ");
	scanf("%d%d", &first, &last);

	for(value = first; value <= last; ++value)
	{
		#ifdef _SQUARES
		result += value * value;
		#else
		result += value;
		#endif
	}

	printf("Result = %d\n", result);
}
