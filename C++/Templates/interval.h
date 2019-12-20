#include <iostream>

class Interval
{
public:
	explicit Interval(int min=0, int sec=0)
	{
		minutes = min + sec / 60;
		seconds = sec % 60;
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

	int Minutes() const
	{
		return minutes;
	}

	int Seconds() const
	{
		return seconds;
	}	

private:
	int minutes;
	int seconds;

	friend std::ostream& operator<<(std::ostream& out, const Interval& val);
};

std::ostream& operator<<(std::ostream& out, const Interval& val)
{
	if(val.seconds < 10)
		out << val.minutes << ":0" << val.seconds;
	else
		out << val.minutes << ":" << val.seconds;
	return out;
}
