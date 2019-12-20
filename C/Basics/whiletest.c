#include <stdio.h>

int main(void)
{
	int num, sum = 0;

	printf("Enter a positive number: ");
	scanf("%d", &num);

	while(num)
	{
		sum += num % 10; //remainder
		num /= 10;		//quotient
	}

	printf("Sum of digits = %d\n", sum);
}


