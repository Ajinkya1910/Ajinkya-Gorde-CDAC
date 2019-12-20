#include <iostream>
#include <string>

using namespace std;

template<typename V, unsigned int M=16>
class StackContainer
{
public:
	StackContainer()
	{
		count = 0;
	}

	bool Push(const V& value)
	{
		if(count < M)
		{
			items[count++] = value;
			return true;
		}

		return false;
	}

	bool Pop(V& value)
	{
		if(count > 0)
		{
			value = items[--count];
			return true;
		}

		return false;
	}

	typedef V* Iterator;

	Iterator Begin()
	{
		return &items[0];
	}

	Iterator End()
	{
		return &items[count];
	}
private:
	V items[M];
	int count;
};

template<typename I, typename P>
void PrintIf(I begin, I end, P check)
{
	for(I i = begin; i != end; ++i)
	{
		if(check(*i))
			cout << *i << " ";
	}

	cout << endl;
}

bool IsOdd(int n)
{
	return (n % 2);
}

class IsBiggerThan
{
public:
	IsBiggerThan(double lim) : limit(lim){}
	bool operator()(double value) const
	{
		return value > limit;
	}
private:
	double limit;
};

int main(void)
{
	StackContainer<string, 8> a;
	a.Push("Monday");
	a.Push("Tuesday");
	a.Push("Wednesday");
	a.Push("Thursday");
	a.Push("Friday");
	for(string i; a.Pop(i);)
		cout << i << endl;
	cout << "-----------------------------" << endl;
	
	StackContainer<int> b;
	b.Push(1);
	b.Push(4);
	b.Push(9);
	b.Push(16);
	b.Push(25);
	b.Push(36);
	b.Push(49);
	b.Push(64);
	for(StackContainer<int>::Iterator i = b.Begin(); i != b.End(); ++i)
		cout << *i << endl;
	cout << "Odd values in above list" << endl;
	PrintIf(b.Begin(), b.End(), IsOdd);
	cout << "-----------------------------" << endl;

	StackContainer<double, 5> c;
	c.Push(23.1);
	c.Push(45.2);
	c.Push(38.3);
	c.Push(52.4);
	c.Push(19.5);
	c.Push(61.6);
	for(StackContainer<double, 5>::Iterator i = c.Begin(); i != c.End(); ++i)
		cout << *i << endl;
	cout << "Big values in above list" << endl;
	PrintIf(c.Begin(), c.End(), IsBiggerThan(30));
}



