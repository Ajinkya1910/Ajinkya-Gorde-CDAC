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

	try
	{
		int i = Find(name);
		cout << "Balance: " << balances[i] << endl;
	}
	catch(string n)
	{
		cout << "Cannot find " << n << endl;
	}
	catch(NameTooSmall)
	{
		cout << "Name must have at least four characters!" << endl; 
	}
}

int main(void)
{
	cout << "Welcome to our bank..." << endl;
	Run();
	cout << "Goodbye." << endl;
}

