package com.callmejo.sharedpreferencesapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import android.content.SharedPreferences.Editor;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String MyPREFERENCES = "MyPref";
    public static final String Name = "Jomon";

    EditText txt_name;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        txt_name = (EditText) findViewById(R.id.txt_name);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void saveMe(View view) {

        String name = txt_name.getText().toString();
        Editor editor = sharedPreferences.edit();
        editor.putString(Name, name);
        editor.commit();
        Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();

    }

    public void showMe(View view) {
//        Toast.makeText(getApplicationContext(), "Searching", Toast.LENGTH_SHORT).show();
        if (sharedPreferences.contains(Name)) {
            Toast.makeText(getApplicationContext(), sharedPreferences.getString(Name, ""), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Empty value here", Toast.LENGTH_LONG).show();
        }

    }

    public void checkGpsStatus(View view) {

        if (hasGps()) {
            //Do what you need if enabled...
            Toast.makeText(getApplicationContext(), "GPS OK", Toast.LENGTH_SHORT).show();
        } else {
            //Do what you need if not enabled...
            Toast.makeText(getApplicationContext(), "Please Enable GPS", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean hasGps() {
        LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return manager.isProviderEnabled(LocationManager.GPS_PROVIDER);

    }

    public void isOnline(View view) {
        if (isNetworkConnected()) {
            Toast.makeText(getApplicationContext(), "You Are Online", Toast.LENGTH_SHORT).show();

        } else {
            //Do what you need if not enabled...
            Toast.makeText(getApplicationContext(), "You Are Offline", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            // There are no active networks.
            return false;
        } else
            return true;
    }

}
