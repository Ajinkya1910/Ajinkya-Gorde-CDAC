#include <stdio.h>
#include <unistd.h> //standard System V functions

void PowerPause(int seconds)
{
	int t[] = {seconds, 0};
	__asm__("syscall" :: "a"(35), "D"(&t));
}

void PortablePause(int seconds)
{
	usleep(1000000 * seconds);
}

int main(int argc, char* argv[])
{
	register int i;

	puts("Hello");
	for(i = 1; i < argc; ++i)
	{
		puts(argv[i]);
		#if defined(__linux__) && defined(__x86_64__)
		PowerPause(i);
		#else
		PortablePause(i);
		#endif
	}
	puts("Goodbye");
}



