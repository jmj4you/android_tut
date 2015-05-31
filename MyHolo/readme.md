<h5>It worked first there has no <code>   android:theme="@style/MyHolo"</code> in activity_main.xml. But I want to make custom theme. </h5>
#MyHolo theme I downloaded from http://android-holo-colors.com/ by these criteria
<a href="#">Here the criteria screen short</a>
# onclick is not working in My custom Holo theme.
<pre>

  26761-26761/com.callmejo.myholo E/AndroidRuntime﹕ FATAL EXCEPTION: main
     Process: com.callmejo.myholo, PID: 26761
     java.lang.IllegalStateException: Could not find a method clickMe(View) in the activity class android.view.ContextThemeWrapper for onClick handler on view class android.widget.Button with id 'button'
             at android.view.View$1.onClick(View.java:4007)
             at android.view.View.performClick(View.java:4780)
             at android.view.View$PerformClick.run(View.java:19866)
             at android.os.Handler.handleCallback(Handler.java:739)
             at android.os.Handler.dispatchMessage(Handler.java:95)
             at android.os.Looper.loop(Looper.java:135)
             at android.app.ActivityThread.main(ActivityThread.java:5254)
             at java.lang.reflect.Method.invoke(Native Method)
             at java.lang.reflect.Method.invoke(Method.java:372)
             at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:903)
             at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:698)
      Caused by: java.lang.NoSuchMethodException: clickMe [class android.view.View]
             at java.lang.Class.getMethod(Class.java:664)
             at java.lang.Class.getMethod(Class.java:643)
             at android.view.View$1.onClick(View.java:4000)
             at android.view.View.performClick(View.java:4780)
             at android.view.View$PerformClick.run(View.java:19866)
             at android.os.Handler.handleCallback(Handler.java:739)
             at android.os.Handler.dispatchMessage(Handler.java:95)
             at android.os.Looper.loop(Looper.java:135)
             at android.app.ActivityThread.main(ActivityThread.java:5254)
             at java.lang.reflect.Method.invoke(Native Method)
             at java.lang.reflect.Method.invoke(Method.java:372)
             at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:903)
             at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:698)
 </pre>

 #activity_main.xml
 <code>
 <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
     xmlns:tools="http://schemas.android.com/tools" android:layout_width="match_parent"
     android:layout_height="match_parent" android:paddingLeft="@dimen/activity_horizontal_margin"
     android:paddingRight="@dimen/activity_horizontal_margin"
     android:paddingTop="@dimen/activity_vertical_margin"
     android:paddingBottom="@dimen/activity_vertical_margin" tools:context=".MainActivity"
     android:theme="@style/MyHolo"
     >


     <Button
         android:layout_width="match_parent"
         android:layout_height="wrap_content"
         android:text="CLICK ME"
         android:id="@+id/button"
         android:layout_centerVertical="true"
         android:layout_centerHorizontal="true"
         android:onClick="clickMe"
         />
 </RelativeLayout>

 </code>

 #MainActivity.java
 <pre>
 package com.callmejo.myholo;

 import android.app.Activity;
 import android.os.Bundle;
 import android.view.Menu;
 import android.view.MenuItem;
 import android.view.View;
 import android.widget.Toast;


 public class MainActivity extends Activity {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
     }

     public void clickMe(View view){
         Toast.makeText(getApplicationContext(),"Its working fine!",Toast.LENGTH_LONG).show();
     }
 }

 </pre>

 # My gradle file
 <pre>
 apply plugin: 'com.android.application'

 android {
     compileSdkVersion 22
     buildToolsVersion "22.0.1"

     defaultConfig {
         applicationId "com.callmejo.myholo"
         minSdkVersion 21
         targetSdkVersion 22
         versionCode 1
         versionName "1.0"
     }
     buildTypes {
         release {
             minifyEnabled false
             proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
         }
     }
 }

 dependencies {
     compile fileTree(dir: 'libs', include: ['*.jar'])
 }
</pre>