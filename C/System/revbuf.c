int ProcessBuffer(char buffer[], int count)
{
	register int i, j;

	for(i = 0, j = count - 1; i < j; ++i, j--)
	{
		char ic = buffer[i];
		char jc = buffer[j];
		buffer[i] = jc;
		buffer[j] = ic;
	}

	return count;
}

