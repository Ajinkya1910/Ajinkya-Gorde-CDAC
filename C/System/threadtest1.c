#include "worker.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

pthread_key_t client;

void HandleJob(int id)
{
	printf("Worker<%x> has accepted job<%d> for %s\n", pthread_self(), id, pthread_getspecific(client));
	DoWork(id);
	printf("Worker<%x> has finished job<%d> for %s\n", pthread_self(), id, pthread_getspecific(client));
}

void* ChildStart(void* arg)
{
	pthread_setspecific(client, "Daughter");
	HandleJob(60);

	return NULL;
}

int main(void)
{
	pthread_t child;
	
	pthread_key_create(&client, NULL);
	pthread_create(&child, 0, ChildStart, NULL);

	pthread_setspecific(client, "Mother");
	HandleJob(50);

	pthread_join(child, NULL); //current thread waits for child thread to exit
	pthread_key_delete(client);
}

