package com.wz.androidjnitest.ndk;

/**
 * Created by HFS on 2017/9/18.
 */

public class NdkTest {

    public native String ndkSayHello();

    static {
        System.loadLibrary("JniTest");
    }
}
