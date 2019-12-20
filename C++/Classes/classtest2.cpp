#include <iostream>

using namespace std;

class Interval
{
public:
	//default constructor - can be called without any argument
	Interval()
	{
		seconds = 0;
	}

	//conversion constructor - can be called with one argument
	Interval(int time)
	{
		seconds = time;
	}

	//parameterized constructor - called explicitly like a function with arguments
	Interval(int sec, int min)
	{
		seconds = 60 * min + sec;
	}	

	void SetTime(int value)
	{
		seconds = value;
	}

	int GetTime()
	{
		return seconds;
	}

	void Print()
	{
		int m = seconds / 60;
		int s = seconds % 60;
		
		if(s < 10)
			cout << m << ":0" << s << endl;
		else
			cout << m << ":" << s << endl;
	}
private:
	int seconds;
};

int main(void)
{
	Interval jack; //automatic activation (on stack) using default constructor
	jack.SetTime(125);
	cout << "Jack's Interval = ";
	jack.Print();

	Interval john = 200; //automatic activation using conversion constructor
	cout << "John's Interval = ";
	john.Print();

	Interval jeff(100, 4); //automatic activation using paremeterized constructor
	cout << "Jeff's Interval = ";
	jeff.Print();
}


