namespace Shapes
{
	int dimension = 2;

	int SquareArea(short side)
	{
		return side * side;
	}

	struct Rectangle
	{
		short length;
		short breadth;
	};

	int RectangleArea(Rectangle r)
	{
		return r.length * r.breadth;
	}
}


