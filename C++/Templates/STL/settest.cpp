#include "interval.h"
#include <iostream>
#include <set>
#include <functional>

using namespace std;

int main(void)
{
	//set<Interval> store;
	set<Interval, greater<Interval> > store;
	store.insert(Interval(5, 31));
	store.insert(Interval(7, 42));
	store.insert(Interval(4, 13));
	store.insert(Interval(6, 54));
	store.insert(Interval(3, 25));
	store.insert(Interval(2, 133));

	for(set<Interval>::iterator i = store.begin(); i != store.end(); ++i)
		cout << *i << "\t" << i->GetTime() << endl;

}


