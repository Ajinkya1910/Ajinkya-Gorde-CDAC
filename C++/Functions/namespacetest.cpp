#include "shapes.h"

int dimension = 3;

int main(void)
{
	int dimension = 4;

	Shapes::Rectangle frame = {8, 3};
	//return dimension + ::dimension + Shapes::dimension;
	return Shapes::SquareArea(5) + RectangleArea(frame); //resolving namespace from parameter type (Koenig's resolution)
}

