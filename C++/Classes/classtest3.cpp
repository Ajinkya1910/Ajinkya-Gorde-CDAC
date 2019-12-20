#include <iostream>

using namespace std;

class Interval
{
public:

	//parameterized constructor - can also be used as default and conversion constructors
	Interval(int sec=0, int min=0)
	{
		seconds = 60 * min + sec;
		++count;
	}	

	void SetTime(int value)
	{
		seconds = value;
	}

	int GetTime()
	{
		return seconds;
	}

	//instance method - it must be called on an object (using . operator)
	//it receives 'this' argument which points to the object on which it is called
	//so it can refer to any field of its class
	void Print()
	{
		int m = seconds / 60;
		int s = seconds % 60;
		
		if(s < 10)
			cout << m << ":0" << s << endl;
		else
			cout << m << ":" << s << endl;
	}

	//static method - it can called on the class (using :: operator)
	//does not receive 'this' argument
	//it can only refer to static fields of its class
	static int CountActiveObjects()
	{
		return count;
	}

	//destructor - called implicitly when object is deactivated
	~Interval()
	{
		count--;
	}
private:
	int seconds; //instance field - each object receives its own value for this field
	static int count; //static field - all objects share a single value of this field
};

int Interval::count = 0; //allocating memory for static field of a class

void Run(void)
{
	cout << "Activating john's Interval" << endl;
	Interval john = 200; 
	cout << "John's Interval = ";
	john.Print();

	//stack-semantics - a locally activated object is deactivated when it goes out of scope
	cout << "Deactivating john's Interval" << endl;
}

int main(void)
{
	cout << "Activating jack's Interval" << endl;
	Interval jack; 
	jack.SetTime(125);
	cout << "Jack's Interval = ";
	jack.Print();

	Run();

	cout << "Activating jeff's Interval" << endl;
	Interval jeff(10, 4);
	cout << "Jeff's Interval = ";
	jeff.Print(); //instance method call with this = &jeff

	cout << "Number of active Intervals = "
		 << Interval::CountActiveObjects() //static method call
		 << endl;

	cout << "Deactivating jeff's Interval" << endl;
	cout << "Deactivating jack's Interval" << endl;
}


