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

template<>
class IndexedValue<string, bool> //full specialization of class template
{
public:
	void Bind(string i, bool v)
	{
		index = i;
		value = v;
	}

	void Print() const
	{
		cout << index << " => " << (value ? "true" : "false") << endl;
	}
private:
	string index;
	bool value;
};

int main(void)
{
	IndexedValue<int, string> a; //activating templated IndexedValue class with I=int, V=string
	a.Bind(12, "Jill");
	a.Print();

	IndexedValue<string, bool> b; //activating specialized IndexedValue
	b.Bind("Monday", true);
	b.Print();

}

