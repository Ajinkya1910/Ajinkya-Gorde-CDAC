#include <iostream>

extern double Power(double, short);

double GetIncome(double invest, short duration, double rate)
{
	double amount = invest * Power(1 + rate / 100, duration);
	return amount - invest;
}

//call to this function will be replaced by its body
inline double GetIncome(double invest, short duration)
{
	return GetIncome(invest, duration, duration < 3 ? 6.0 : 6.5);
}

int main(void)
{
	double p;
	short n;

	std::cout << "Investment and duration: ";
	std::cin >> p >> n;

	std::cout << "Your income in savings-account = "
			  << GetIncome(p, n, 4.0)
			  << std::endl;
	std::cout << "Your income in fixed-deposit = "
			  << GetIncome(p, n) //GetIncome(p, n, n < 3 ? 6.0 : 6.5)
			  << std::endl;
}

