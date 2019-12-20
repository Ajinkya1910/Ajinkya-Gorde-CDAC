#include "banking2.h"
#include <iostream>

using namespace Banking;
using namespace std;

void DeductTax(Account* accounts[], int count)
{
	for(int i = 0; i < count; ++i)
	{
		double bal = accounts[i]->Balance();
		if(bal > 25000)
			accounts[i]->Withdraw(0.05 * (bal - 25000));
	}
}

void PayAnnualInterest(Account* accounts[], int count)
{
	for(int i = 0; i < count; ++i)
	{
		Profitable* p = dynamic_cast<Profitable*>(accounts[i]);
		if(p)
		{
			double amt = p->Interest(12);
			accounts[i]->Deposit(amt);
		}
	}
}

int main(void)
{
	Account* bank[5];
	bank[0] = OpenSavingsAccount();
	bank[0]->Deposit(5000);
	bank[1] = OpenCurrentAccount();
	bank[1]->Deposit(20000);
	bank[2] = OpenSavingsAccount();
	bank[2]->Deposit(25000);
	bank[3] = OpenCurrentAccount();
	bank[3]->Deposit(40000);
	bank[4] = OpenSavingsAccount();
	bank[4]->Deposit(45000);

	DeductTax(bank, 5);
	PayAnnualInterest(bank, 5);

	for(int i = 0; i < 5; ++i)
	{
		cout << (i + 1) << "\t" << bank[i]->Balance() << endl;
		CloseAccount(bank[i]);
	}
}

