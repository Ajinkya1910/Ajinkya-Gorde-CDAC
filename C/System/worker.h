#include <time.h>

int DoWork(int amount)
{
	clock_t t = clock();
	
	if(amount == 0)
		amount = time(NULL) % 10 + 1;

	while(clock() < t + amount * CLOCKS_PER_SEC / 10);

	return amount;
}


