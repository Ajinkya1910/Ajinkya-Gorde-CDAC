#include <stdio.h>

extern int CountPrimes(int, int);

int main(void)
{
	int l, u;

	printf("Enter lower and upper limits: ");
	scanf("%d%d", &l, &u);

	printf("Number of primes = %d\n", CountPrimes(l, u));
}

