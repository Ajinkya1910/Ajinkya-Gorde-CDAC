#include <iostream>

extern double Power(double, short);

double GetIncome(double invest, short duration, double rate)
{
	double amount = invest * Power(1 + rate / 100, duration);
	return amount - invest;
}

int main(void)
{
	double p;
	short n;

	std::cout << "Investment and duration: ";
	std::cin >> p >> n;

	std::cout << "Your Income = "
			  << GetIncome(p, n, 6.0)
			  << std::endl;
}

