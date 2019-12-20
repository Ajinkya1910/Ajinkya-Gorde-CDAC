char salt = '#';

int ProcessBuffer(char buffer[], int count)
{
	register int i;

	for(i = 0; i < count; ++i)
		buffer[i] ^= salt;

	return count;
}



