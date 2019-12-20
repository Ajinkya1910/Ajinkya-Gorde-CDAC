#include "interval.h"
#include <iostream>
#include <string>

using namespace std;

template<typename I, typename V>
class IndexedValue // IndexedValue class template
{
public:
	void Bind(I i, V v)
	{
		index = i;
		value = v;
	}

	void Print() const
	{
		cout << index << " => " << value << endl;
	}
private:
	I index;
	V value;
};

int main(void)
{
	IndexedValue<int, string> a; //activating templated IndexedValue class with I=int, V=string
	a.Bind(12, "Jill");
	a.Print();

	IndexedValue<string, double> b;
	b.Bind(13, 4.5);
	b.Print();

	IndexedValue<string, Interval> c;
	c.Bind("Tuesday", Interval(4, 30));
	c.Print();
}

