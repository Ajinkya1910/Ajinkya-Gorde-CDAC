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

	switch(room)
	{
	case 1:
		rate = 349.75;
		break;
	case 2:	
		rate = 599.75;
		break;
	case 3:
		rate = 849.75;
		break;
	default:
		rate = 999.75;
	}
	payment = 1.15 * rate * days;

	printf("Total payment: %.2lf\n", payment);
}


