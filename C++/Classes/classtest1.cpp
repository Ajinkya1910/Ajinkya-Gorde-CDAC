#include <iostream>

using namespace std;

/*
class Interval
{
public:
	void SetTime(int value) //void _ZN8Interval7SetTimeEi(Interval* this, int value)
	{
		minutes = value / 60; //this->minutes = value / 60;
		seconds = value % 60; //this->seconds = value % 60;
	}

	int GetTime()
	{
		return 60 * minutes + seconds;
	}

	void Print()
	{
		if(seconds < 10)
			cout << minutes << ":0" << seconds << endl;
		else
			cout << minutes << ":" << seconds << endl;
	}
private:
	int minutes;
	int seconds;
};
*/

class Interval
{
public:
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


float Speed(float distance, Interval duration)
{
	return 3.6 * distance / duration.GetTime();
}

int main(void)
{
	Interval jack;
	jack.SetTime(125); //_ZN8Interval7SetTimeEi(&jack, 125)
	cout << "Jack's Interval = ";
	jack.Print();
	cout << "Jack's Speed = "
		 << Speed(500, jack)
		 << endl;

	Interval john;
	john.SetTime(200); //_ZN8Interval7SetTimeEi(&john, 200)
	cout << "John's Interval = ";
	john.Print();
	cout << "John's Speed = "
		 << Speed(500, john)
		 << endl;
}


