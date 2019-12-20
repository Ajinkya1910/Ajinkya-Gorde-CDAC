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

	Interval(const Interval& other)
	{
		minutes = other.minutes;
		seconds = other.seconds;
		cout << "Interval object copy activated" << endl;
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

	void operator=(const Interval& other) 
	{
		minutes = other.minutes;
		seconds = other.seconds;
		cout << "Interval object assigned" << endl;
	}

	~Interval()
	{
		cout << "Interval object deactivated" << endl;
	}
private:
	int minutes;
	int seconds;
};

class Journey
{
public:
	Journey(float dis, const Interval& dur) : duration(dur)
	{
		distance = dis;
		//duration = dur;
		cout << "Journey object activated" << endl;
	}

	float Speed() const
	{
		return 3.6 * distance / duration.GetTime();
	}

	~Journey()
	{
		cout << "Journey object deactivated" << endl;
	}
private:
	float distance;
	Interval duration; //composition, use Interval* for aggregation
};

void Run(void)
{
	Interval a(3, 20);
	Journey b(500, a);
	cout << "Speed = " << b.Speed() << endl;
}

int main(void)
{
	cout <<  "Journey begins..." << endl;
	Run();
	cout <<  "Journey ends." << endl;
}



