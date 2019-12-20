#include "interval.h"
#include <iostream>
#include <vector>
#include <algorithm>
#include <functional>

using namespace std;

void Print(const Interval& i)
{
	cout << i << "\t" << i.GetTime() << endl;
}

int main(void)
{
	vector<Interval> store;
	store.push_back(Interval(5, 31));
	store.push_back(Interval(7, 42));
	store.push_back(Interval(4, 13));
	store.push_back(Interval(6, 54));
	store.push_back(Interval(3, 25));

	//sort(store.begin(), store.end());
	sort(store.begin(), store.end(), greater<Interval>());

	for_each(store.begin(), store.end(), Print);
}


