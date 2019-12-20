#include "worker.h"
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

volatile int data = 0;

void Produce(void)
{
	int value;

	printf("Producer<%x> started\n", pthread_self());
	value = DoWork(0);
	printf("Produced data = %d\n", value);
	data = value;
}

void* Consume(void* arg)
{
	int value;

	printf("Consumer<%x> started\n", pthread_self());
	while(data == 0)
		pthread_yield();
	value = data * DoWork(data);
	printf("Consumed data = %d\n", value);

	return NULL;
}

int main(void)
{
	pthread_t child;
	
	pthread_create(&child, 0, Consume, NULL);
	Produce();

	pthread_join(child, NULL);
}

