static int IsPrime(int n)
{
	register int m;

	if(n == 1)
		return 0;
	if(n == 2 || n == 3)
		return 1;
	if((n % 2) == 0)
		return 0;

	for(m = 3; m * m <= n; m += 2)
	{
		if((n % m) == 0)
			return 0;
	}

	return 1;
}

int CountPrimes(int low, int high)
{
	int count = 0;
	register int n;

	for(n = low; n <= high; ++n)
		count += IsPrime(n);

	return count;
}


