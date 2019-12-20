#include <iostream>

using namespace std;

double Average(double first, double second, double& deviation)
{
	deviation = first > second ? (first - second) / 2 : (second - first) / 2;

	return (first + second) / 2;
}

int main(void)
{
	double x,  y;

	cout << "Enter two real values: ";
	cin >> x >> y;

	double d;
	double a = Average(x, y, d);

	cout << "Average is " << a << " with a deviation of " << d << endl;
}


