#include <stdio.h>

short int count = 0; //global variable - visible in all modules of this program

int main(void)
{
	long long int total = 0; //local variable - visible only in this function

	printf("Count: ");
	scanf("%hd", &count);

	total = count * (count + 1) / 2;

	printf("Total = %lld\n", total);
}


