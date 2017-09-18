# AndroidJniTest
Android studio使用JNI实例

具体步骤如下:

第一步：新建一个类，声明native方法。这个类是java与C/C++交互的中介，方法由java声明，由C/C++实现。

```java
public class NdkTest {

    public native String ndkSayHello();

    static {
        System.loadLibrary("JniTest");
    }
}
```


第二步：在我们的builde.gradle文件下的defaultConfig中添加我们的NDK信息

```xml
 ndk{
            moduleName "JniTest"
            abiFilters "armeabi","armeabi-v7a","x86"
        }
```

第三步：在 gradle.properties文件中加入 android.useDeprecatedNdk =true,同步下项目

第四步：执行javac命令
```java
cd AndroidJniTest\app\build\intermediates\classes\debug 执行javah -jni com.wz.androidjnitest.ndk.NdkTest
```

第五步：在main文件下创建jni文件夹。将上面生成的.h文件复制到jni文件夹下面，继续在jni下面创建一个JniTest.c的文件（名字可随意）

第六步：编写JniTest.c

```java
#include <jni.h>

JNIEXPORT jstring JNICALL Java_com_wz_androidjnitest_ndk_NdkTest_ndkSayHello
        (JNIEnv *env, jobject j) {
    return (*env)->NewStringUTF(env, "Hello jni!");
};
```

编译成功后，AndroidJniTest\app\build\intermediates\ndk\debug\lib 目录会生成我们在第3步中配置的3个文件 并且在文件下 有我们需要的.so文件

第七步：调用

 ```java
 public class MainActivity extends AppCompatActivity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         NdkTest ndkTest = new NdkTest();
         ((TextView)findViewById(R.id.tv_test)).setText(ndkTest.ndkSayHello());
     }
 }
 ```


 OK,完成了