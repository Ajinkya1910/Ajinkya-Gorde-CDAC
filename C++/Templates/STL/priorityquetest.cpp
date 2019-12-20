#include "interval.h"
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

class IntervalCompare
{
public:
	bool operator()(const Interval& x, const Interval& y) const
	{
		return x.Seconds() < y.Seconds();
	}
};

int main(void)
{
	//priority_queue<Interval> store;
	priority_queue<Interval, vector<Interval>, IntervalCompare> store;
	store.push(Interval(5, 31));
	store.push(Interval(7, 42));
	store.push(Interval(4, 13));
	store.push(Interval(6, 54));
	store.push(Interval(3, 25));

	while(!store.empty())
	{
		cout << store.top() << endl;
		store.pop();
	}	
}


