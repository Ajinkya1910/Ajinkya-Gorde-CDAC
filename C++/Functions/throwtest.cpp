#include <iostream>
#include <string>

using namespace std;

struct NameTooSmall
{
};

int Find(string name)
{
	string names[] = {"jack", "jill", "john", "jane"};

	if(name.size() < 4)
	{
		NameTooSmall sn;
		throw sn;
	}

	for(int i = 0; i < 4; ++i)
	{
		if(names[i] == name)
			return i;
	}

	throw name;
}

void Run(void)
{
	int balances[] = {6000, 7000, 5000, 3000};
	
	string name;
	cout << "Name: ";
	cin >> name;

	int i = Find(name);
	cout << "Balance: " << balances[i] << endl;

}

int main(void)
{
	cout << "Welcome to our bank..." << endl;
	Run();
	cout << "Goodbye." << endl;
}

