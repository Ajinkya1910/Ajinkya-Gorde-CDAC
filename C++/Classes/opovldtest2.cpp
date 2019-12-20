#include <iostream>

using namespace std;

class Interval
{
public:
	Interval(int min, int sec)
	{
		seconds = 60 * min + sec;
	}

	Interval(int time=0)
	{
		seconds = time;
	}

	void SetTime(int value)
	{
		seconds = value;
	}

	int GetTime() const 
	{
		return seconds;
	}

	void Print() const
	{
		int m = seconds / 60;
		int s = seconds % 60;
		
		if(s < 10)
			cout << m << ":0" << s << endl;
		else
			cout << m << ":" << s << endl;
	}

	//prefix ++
	Interval operator++() 
	{
		return Interval(++seconds);
	}

	//postfix ++
	Interval operator++(int)
	{
		return Interval(seconds++);
	}

	int operator[](int index) const
	{
		return index ? (seconds / 60) : (seconds % 60);
	}

	operator float() const
	{
		return seconds / 60.0;
	}

private:
	int seconds;
};


int main(void)
{
	Interval a(5, 43);
	a.Print();

	Interval b = ++a;
	b.Print();
	a.Print();

	Interval c = b++;
	c.Print();
	b.Print();

	cout << "First Interval has "
		 << a[1] << " minutes and "
		 << a[0] << " seconds." << endl;

	float d = b;
	cout << d << endl;
}


