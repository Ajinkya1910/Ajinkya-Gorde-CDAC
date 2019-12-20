#include "banking1.h"
#include <iostream>

using namespace Banking;
using namespace std;

int main(void)
{
	Account* jack = OpenCurrentAccount();
	jack->Deposit(20000);

	Account* jill = OpenSavingsAccount();
	jill->Deposit(15000);

	double payment;
	cout << "Jill's payment: ";
	cin >> payment;

	try
	{
		jill->Transfer(payment, jack);
		cout << "Payment transferred." << endl;
	}
	catch(InsufficientFunds)
	{
		cout << "Transfer failed due to lack of funds!" << endl;
	}

	cout << "Jack's Balance = " << jack->Balance() << endl;
	cout << "Jill's Balance = " << jill->Balance() << endl;

	CloseAccount(jack);
	CloseAccount(jill);
}

