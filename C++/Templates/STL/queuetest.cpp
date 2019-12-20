#include "interval.h"
#include <iostream>
#include <list>
#include <queue>

using namespace std;

int main(void)
{
	//queue<Interval> store;
	queue<Interval, list<Interval> > store;
	store.push(Interval(5, 31));
	store.push(Interval(7, 42));
	store.push(Interval(4, 13));
	store.push(Interval(6, 54));
	store.push(Interval(3, 25));

	while(!store.empty())
	{
		cout << store.front() << endl;
		store.pop();
	}	
}


