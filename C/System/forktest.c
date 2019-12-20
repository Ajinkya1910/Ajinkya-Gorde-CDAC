#include "worker.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

char* client;

void HandleJob(int id)
{
	printf("Worker<%d/%d> has accepted job<%d> for %s\n", getpid(), getppid(), id, client);
	DoWork(id);
	printf("Worker<%d/%d> has finished job<%d> for %s\n", getpid(), getppid(), id, client);
}

int main(void)
{
	pid_t child;

	child = fork();
	if(child == 0)
	{
		client = "Daughter";
		HandleJob(60);
	}
	else
	{
		client = "Mother";
		HandleJob(50);
		waitpid(child, NULL, 0);
	}

}



