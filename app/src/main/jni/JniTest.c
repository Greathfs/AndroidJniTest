#include <jni.h>

JNIEXPORT jstring JNICALL Java_com_wz_androidjnitest_ndk_NdkTest_ndkSayHello
        (JNIEnv *env, jobject j) {
    return (*env)->NewStringUTF(env, "Hello jni!");
};