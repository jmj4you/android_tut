package com.callmejo.mywebview;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;


public class CallbackActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callback);
        Uri data = getIntent().getData();
        String scheme = data.getScheme(); // "http"
        String host = data.getHost(); // "twitter.com"
        List<String> params = data.getPathSegments();
        String first = params.get(0); // "status"
//        String second = params.get(1); // "1234"

        Log.e("host:", host);
        Log.e("1:",first);
        //mbc.app.login.callback://mybloodcare.net/ofS9EmJGXrghTNmvEeZZk1AISCAJXqT88YLmLZv4/604800000/Bearer


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_callback, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
