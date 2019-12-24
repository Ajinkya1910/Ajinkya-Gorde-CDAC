#include "legacy\include\taxation.h"

namespace IjwTax
{
	//managed reference type
	public ref class LegacyTaxPayer
	{
	public:
		property double Income;
		
		double GetIncomeTax(short age)
		{
			Taxation::TaxPayer payer(age);
			return payer.IncomeTax(Income);
		}
	};
}
