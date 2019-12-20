#ifndef BANKING2_H
#define BANKING2_H

namespace Banking
{
	class InsufficientFunds{};

	class Account
	{
	public:
		double Balance() const;
		virtual void Deposit(double) = 0; //pure virtual member function
		virtual void Withdraw(double) throw(InsufficientFunds) = 0;
		void Transfer(double, Account*) throw(InsufficientFunds);
		virtual ~Account(){}
	protected:
		double balance;
	};

	class Profitable
	{
	public:
		virtual double Interest(short) const = 0;
		virtual ~Profitable(){}
	};

	//factory functions
	Account* OpenCurrentAccount();

	Account* OpenSavingsAccount();

	void CloseAccount(Account*);
}


#endif


