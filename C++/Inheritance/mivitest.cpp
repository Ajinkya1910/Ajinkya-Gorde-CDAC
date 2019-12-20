#include <iostream>
#include <string>

using namespace std;

class TaxPayer
{
public:
	virtual double AnnualIncome() const = 0;

	double IncomeTax() const
	{
		double free = 150000 + 50000 * (age >= 60);
		double extra = AnnualIncome() - free;

		return extra > 0 ? 0.15 * extra : 0;
	}

	virtual ~TaxPayer(){}
protected:
	TaxPayer(int ag)
	{
		age = ag;
	}
private:
	int age;
};

void Print(const string& name, const TaxPayer* tp)
{
	cout << "Income tax of "
		 << name 
		 << " is "
		 << tp->IncomeTax()
		 << endl;
}

class Employee : public TaxPayer
{
public:
	Employee(double sy, int ag) : TaxPayer(ag)
	{
		salary = sy;
	}

	double AnnualIncome() const
	{
		return 12 * salary + 25000;
	}
private:
	double salary;
};

class Dealer : public TaxPayer
{
public:
	Dealer(double ss, int ag) : TaxPayer(ag)
	{
		sales = ss;
	}

	double AnnualIncome() const
	{
		return 0.15 * sales;
	}
private:
	double sales;
};

class SalesPerson : public Employee, public Dealer
{
public:
	SalesPerson(double sy, double ss, int ag) : Employee(sy, ag), Dealer(ss, ag)
	{
	}

	double AnnualIncome() const
	{
		return Employee::AnnualIncome() - 25000
			 + Dealer::AnnualIncome() / 3;
	}
};

int main(void)
{
	Employee* jill = new Employee(24000, 36);
	Dealer* john = new Dealer(4800000, 63);
	SalesPerson* jeff = new SalesPerson(14000, 3500000, 28); 

	Print("Jill the Employee", jill);
	Print("John the Dealer", john);
	Print("Jeff the SalesPerson", jeff);

	delete jeff;
	delete john;
	delete jill;
}


