#include "box.h"

/*
void BoxSetDimensions(Box box, short length, short breadth, short height)
{
	box[0] = length;
	box[1] = breadth;
	box[2] = height;
}

int BoxGetVolume(Box box)
{
	int l = box[0];
	int b = box[1];
	int h = box[2];

	return l * b * h;
}
*/

void BoxSetDimensions(Box box, short length, short breadth, short height)
{
	box[0] = length;
	box[1] = breadth;
	box[2] = height;
	box[3] = 0;
}

void BoxSetThickness(Box box, short thickness)
{
	box[3] = thickness;
}

int BoxGetVolume(Box box)
{
	int l = box[0] - 2 * box[3];
	int b = box[1] - 2 * box[3];
	int h = box[2] - 2 * box[3];

	return l * b * h;
}


