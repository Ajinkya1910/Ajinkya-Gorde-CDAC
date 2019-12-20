#include <iostream>

using namespace std;

class Interval
{
public:
	explicit Interval(int min=0, int sec=0)
	{
		minutes = min + sec / 60;
		seconds = sec % 60;
		cout << "Interval object activated" << endl;
	}

	void SetTime(int value)
	{
		minutes = value / 60;
		seconds = value % 60;
	}

	int GetTime() const
	{
		return 60 * minutes + seconds;
	}

	void Print() const
	{
		if(seconds < 10)
			cout << minutes << ":0" << seconds << endl;
		else
			cout << minutes << ":" << seconds << endl;
	}

	~Interval()
	{
		cout << "Interval object deactivated" << endl;
	}
private:
	int minutes;
	int seconds;
};

float Speed(float distance, const Interval& duration)
{
	return 3.6 * distance / duration.GetTime();
}

void Run(void)
{
	int n;
	cout << "Number of Intervals: ";
	cin >> n;

	Interval* list = new Interval[n]; //dynamically activates n objects using default constructor and returns address of first object
	for(int i = 0; i < n; ++i)
	{
		list[i].SetTime(95 * i + 80);
		list[i].Print();
	}
	delete[] list;
}

int main(void)
{
	Interval* jack = new Interval; //dynamic activation using default constructor
	jack->SetTime(125);
	cout << "Jack's Interval = ";
	jack->Print();
	cout << "Jack's Speed = "
		 << Speed(500, *jack)
		 << endl;
	delete jack;

	Run();

	Interval* john = new Interval(2, 80); //dynamic activation using parameterized constructor
	cout << "John's Interval = ";
	john->Print();
	cout << "John's Speed = "
		 << Speed(500, *john)
		 << endl;
	delete john;


}


