#include <iostream>

using namespace std;

class Interval
{
public:
	//cannot be used as conversion constructor
	explicit Interval(int min=0, int sec=0)
	{
		seconds = 60 * min + sec;
		++count;
	}	

	void SetTime(int value)
	{
		seconds = value;
	}

	int GetTime() const // int _ZNK8Interval7GetTimeEv(const Interval* this)
	{
		return seconds; //this->seconds
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

	static int CountActiveObjects()
	{
		return count;
	}

	~Interval()
	{
		count--;
	}
private:
	int seconds; 
	static int count; 
};

int Interval::count = 0; 

float Speed(float distance, const Interval& duration)
{
	return 3.6 * distance / duration.GetTime();
}

int main(void)
{
	Interval jack; 
	jack.SetTime(125);
	cout << "Jack's Interval = ";
	jack.Print();
	cout << "Jack's Speed = "
		 << Speed(500, jack)
		 << endl;

	Interval jeff(0, 200);
	cout << "Jeff's Interval = ";
	jeff.Print(); 
	cout << "Jeff's Speed = "
		 << Speed(500, jeff)
		 << endl;

	cout << "Number of active Intervals = "
		 << Interval::CountActiveObjects() 
		 << endl;

}


