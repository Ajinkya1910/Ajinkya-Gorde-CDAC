#include "ArrayHelper.h"

JNIEXPORT jint JNICALL Java_ArrayHelper_squareAll(JNIEnv* env, jclass, jdoubleArray values)
{
	jint n = env->GetArrayLength(values);
	double* elements = new jdouble[n];

	env->GetDoubleArrayRegion(values, 0, n, elements);
	for(jint i = 0; i < n; ++i)
		elements[i] *= elements[i];
	env->SetDoubleArrayRegion(values, 0, n, elements);

	delete[] elements;

	return n;
}

