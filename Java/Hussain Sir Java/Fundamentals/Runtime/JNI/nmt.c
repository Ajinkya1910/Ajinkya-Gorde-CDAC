#include <jni.h>

jint Java_NativeMethodTest_gcd(JNIEnv* env, jclass cls, jint first, jint second)
{
	while(first != second)
	{
		if(first > second)
			first -= second;
		else
			second -= first;
	}

	return first; 
}
