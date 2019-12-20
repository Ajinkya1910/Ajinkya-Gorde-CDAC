#include "StringHelper.h"

JNIEXPORT jstring JNICALL Java_StringHelper_reverseOf(JNIEnv* env, jclass, jstring str)
{
	jint n = env->GetStringLength(str);
	jchar* buffer = new jchar[n];

	env->GetStringRegion(str, 0, n, buffer);
	for(jint i = 0, j = n - 1; i < j; ++i, j--)
	{
		jchar ic = buffer[i];
		jchar jc = buffer[j];
		buffer[i] = jc;
		buffer[j] = ic;
	}

	jstring result = env->NewString(buffer, n);
	delete[] buffer;

	return result;
}

