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

	Interval operator+(const Interval& other) const
	{
		return Interval(seconds + other.seconds);
	}

	Interval operator*(int scalar) const
	{
		return Interval(scalar * seconds);
	}

private:
	int seconds;

	//a non-member function of this class defined by
	//the author of this class and as such has access
	//to its private members
	friend Interval operator*(int, const Interval&);
};

Interval operator*(int lhs, const Interval& rhs)
{
	return Interval(lhs * rhs.seconds);
}

int main(void)
{
	Interval a(5, 45);
	a.Print();

	Interval b(4, 30);
	b.Print();

	Interval c = a + b; //a.operator+(b)
	c.Print();

	Interval d = 3 * a; //operator(3, a)
	d.Print();
}


