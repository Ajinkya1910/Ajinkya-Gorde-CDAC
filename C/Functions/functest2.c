#include "box.h"
#include <stdio.h>

int main(void)
{
	short l, b, h;
	int vol;
	Box mybox;

	printf("Box Dimensions: ");
	scanf("%hd%hd%hd", &l, &b, &h);

	BoxSetDimensions(mybox, l, b, h);
	#ifdef _NEWBOX
	BoxSetThickness(mybox, 1);
	#endif
	vol = BoxGetVolume(mybox);
	printf("Inner volume = %d\n", vol);
}

