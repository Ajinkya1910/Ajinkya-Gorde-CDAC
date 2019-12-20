#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <dlfcn.h>

int main(int argc, char* argv[])
{
	void* lib;
	int (*pb)(char[], int);

	if(argc < 2)
		return printf("USAGE: %s lib-to-use\n", argv[0]);

	lib = dlopen(argv[1], RTLD_NOW);
	if(lib == NULL)
		return printf("ERROR: Cannot load %s\n", argv[1]);

	pb = dlsym(lib, "ProcessBuffer");
	if(pb)
	{
		char text[80];
		printf("Text to process: ");
		scanf("%[^\n]79s", text);
		pb(text, strlen(text));
		printf("Processed text : %s\n", text);
	}
	else
		puts("ERROR: Invalid library");

	dlclose(lib);
}

