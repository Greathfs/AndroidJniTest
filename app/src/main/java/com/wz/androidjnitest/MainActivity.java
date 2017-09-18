package com.wz.androidjnitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.wz.androidjnitest.ndk.NdkTest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NdkTest ndkTest = new NdkTest();
        ((TextView)findViewById(R.id.tv_test)).setText(ndkTest.ndkSayHello());
    }
}
