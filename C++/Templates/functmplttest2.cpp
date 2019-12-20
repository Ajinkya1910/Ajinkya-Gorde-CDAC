#include "interval.h"
#include <iostream>
#include <string>

using namespace std;

template<typename Any>
void PrintWithName(const string& name, Any value)
{
	cout << name << " => " << value << endl;
}

template<> //explicit specialization for function template for Any=bool
void PrintWithName(const string& name, bool value)
{
	cout << name << " => " << (value ? "true" : "false") << endl;
}

int main(void)
{
	double a = 3.5;
	PrintWithName("first", a);

	string b = "Monday";
	PrintWithName("second", b);

	string c = "Sunday";
	PrintWithName("third", c);

	bool d = true;
	PrintWithName("fourth", d);

	Interval e(3, 45);
	PrintWithName("fifth", e);
}


