#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>

void End(void)
{
	puts("Goodbye User.");
}

void Run(void)
{
	int squares[] = {1, 4, 9, 16, 25, 36, 49, 64, 81};
	int i;

	for(i = 1; i < 4; ++i)
	{
		int value;
		printf("Value %d: ", i);
		scanf("%d", &value);
		printf("Result = %d\n", 2520 / value);
		printf("Square = %d\n", squares[value]);
	}
}

void MainHandler(int signo)
{
	switch(signo)
	{
	case SIGFPE:
		puts("ERROR: Illegal operation!");
		break;
	case SIGSEGV:
		puts("ERROR: Illegal access!");
		break;
	case SIGINT:
		puts("\nWARNING: Interrupted!");
		break;
	}

	exit(signo);
}

int main(void)
{
	struct sigaction act = {MainHandler};
	struct sigaction oact;
	sigaction(SIGFPE, &act, &oact);
	sigaction(SIGSEGV, &act, NULL);
	sigaction(SIGINT, &act, NULL);

	atexit(End);
	puts("Welcome User.");
	Run();
}


