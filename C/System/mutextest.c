#include "worker.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

int result = 0;
pthread_mutex_t gate = PTHREAD_MUTEX_INITIALIZER;

void HandleJob(int id)
{
	int value;

	printf("Worker<%x> has accepted job<%d>\n", pthread_self(), id);
	pthread_mutex_lock(&gate);
	value = result;
	result = value + DoWork(id);
	pthread_mutex_unlock(&gate);
	printf("Worker<%x> has finished job<%d>\n", pthread_self(), id);
}

void* ChildStart(void* arg)
{
	int* id = arg;
	HandleJob(*id);
	return NULL;
}

int main(void)
{
	pthread_t child[5];
	int id[] = {1, 2, 3, 4, 5};

	register int i;

	for(i = 0; i < 5; ++i)
	{
		pthread_create(&child[i], NULL, ChildStart, &id[i]);
	}

	for(i = 0; i < 5; ++i)
		pthread_join(child[i], NULL);

	printf("RESULT = %d\n", result);
}

