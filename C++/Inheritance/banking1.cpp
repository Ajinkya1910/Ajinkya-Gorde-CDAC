#include "banking1.h"

namespace Banking
{
	double Account::Balance() const
	{
		return balance;
	}

	void Account::Transfer(double amount, Account* that) throw(InsufficientFunds)
	{
		if(this != that)
		{
			this->Withdraw(amount);
			that->Deposit(amount);
		}
	}

	class CurrentAccount : public Account
	{
	public:
		CurrentAccount()
		{
			balance = 0;
		}

		void Withdraw(double amount) throw(InsufficientFunds)
		{
			balance -= amount;
		}

		void Deposit(double amount)
		{
			if(balance < 0)
				amount *= 0.9;
			balance += amount;
		}
	};

	class SavingsAccount : public Account
	{
	public:
		SavingsAccount()
		{
			balance = 5000;
		}

		void Deposit(double amount)
		{
			balance += amount;
		}

		void Withdraw(double amount) throw(InsufficientFunds)
		{
			if(balance - amount < 5000)
				throw InsufficientFunds();
			balance -= amount;
		}
	};

	Account* OpenCurrentAccount()
	{
		return new CurrentAccount;
	}

	Account* OpenSavingsAccount()
	{
		return new SavingsAccount;
	}

	void CloseAccount(Account* acc)
	{
		delete acc;
	}
}

