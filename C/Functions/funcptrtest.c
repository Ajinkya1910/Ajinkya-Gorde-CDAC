#include <stdio.h>

long long ProcessAll(short first, short last)
{
	long long result = 0;
	short value;

	for(value = first; value <= last; ++value)
	{
		result += value * value;
	}

	return result;
}

/*
long long ProcessOdd(short first, short last)
{
	long long result = 0;
	short value;

	for(value = first; value <= last; ++value)
	{
		if(value & 1)
			result += value * value;
	}

	return result;
}
*/

long long ProcessIf(short first, short last, int (*check)(short))
{
	long long result = 0;
	short value;

	for(value = first; value <= last; ++value)
	{
		if(check(value))
			result += value * value;
	}

	return result;
}

int IsOdd(short n)
{
	return n & 1;
}

int main(void)
{
	short limit;
	long long result;

	printf("Limit: ");
	scanf("%hd", &limit);

	result = ProcessAll(1, limit);
	printf("Result for all values = %lld\n", result);

	//result = ProcessOdd(1, limit);
	result = ProcessIf(1, limit, IsOdd);
	printf("Result for odd values = %lld\n", result);
}

