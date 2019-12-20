#include <stdio.h>

#define ABS(X) X >=0 ? X : -(X) //a macro

int main(void)
{
	long long number;
	short digits;
	register long long a, b;
	register short c;

	printf("Number: ");
	scanf("%lld", &number);

	a = 1;
	b = ABS(number);
	c = 0;

	do
	{
		a *= 10; // a = a * 10
		c += 1; // c = c + 1
	}
	while(a <= b);

	digits = c;

	printf("Digits = %hd\n", digits);

}

