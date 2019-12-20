#include "LegacyTaxPayer.h"
#include "taxation.h"

JNIEXPORT jdouble JNICALL Java_LegacyTaxPayer_getIncomeTax(JNIEnv* env, jobject obj, jshort age)
{
	jclass cls = env->GetObjectClass(obj);
	jfieldID idIncome = env->GetFieldID(cls, "income", "D");
	jdouble income = env->GetDoubleField(obj, idIncome);
	jmethodID idValidate = env->GetMethodID(cls, "validate", "(S)Z");
	jboolean valid = env->CallBooleanMethod(obj, idValidate, age);

	if(valid == JNI_FALSE)
	{
		jclass ex = env->FindClass("java/lang/IllegalArgumentException");
		env->ThrowNew(ex, "Illegal age");
		return 0;
	}

	Taxation::TaxPayer tp(age);
	return tp.IncomeTax(income);
}

