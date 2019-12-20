#include <stdio.h>

int main(void)
{
	short days;
	int room;
	float rate;
	double payment;

	printf("Number of days : ");
	scanf("%hd", &days);
	puts("1.Economy\n2.Business\n3.Executive\n4.Deluxe");
	printf("Room type [1-4]: ");
	scanf("%d", &room);	

	if(room == 1)
		rate = 349.75;
	else if(room == 2)
		rate = 599.75;
	else if(room == 3)
		rate = 849.75;
	else
		rate = 999.75;
	payment = 1.15 * rate * days;

	printf("Total payment: %.2lf\n", payment);
}


