#include <iostream>

using namespace std;
/*
void Swap(int& first, int& second)
{
	int third = first;
	first = second;
	second = third;
}

void Swap(double& first, double& second)
{
	double third = first;
	first = second;
	second = third;
}
*/

template<typename T>
void Swap(T& first, T& second) //Swap function template with T as a substitutable type
{
	T third = first;
	first = second;
	second = third;
}

int main(void)
{
	int ix = 23, iy = 32;
	cout << "Original int values = " << ix << ", " << iy << endl;
	Swap<int>(ix, iy); //calling templated Swap function with T=int
	cout << "Swapped int values  = " << ix << ", " << iy << endl;
	
	double dx = 4.5, dy = 5.4;
	cout << "Original double values = " << dx << ", " << dy << endl;
	Swap(dx, dy); //Swap<double>(dx, dy) - type inference from arguments
	cout << "Swapped double values = " << dx << ", " << dy << endl;
	Swap(dy, dx);
}



