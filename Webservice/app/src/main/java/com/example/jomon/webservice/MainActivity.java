package com.example.jomon.webservice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import network.VolleySingleton;


public class MainActivity extends Activity {

    TextView usernameTextView, fullnameTextView, errorTextView;
    String url = "http://graph.facebook.com/jmj4you";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameTextView = (TextView) findViewById(R.id.username);
        fullnameTextView = (TextView) findViewById(R.id.fullname);
        errorTextView = (TextView) findViewById(R.id.error);
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

    public void getMyaddress(View view) {
        // Instantiate the RequestQueue.
//        RequestQueue queue = Volley.newRequestQueue(this);
        RequestQueue queue = VolleySingleton.getsInstance().getRequestQueue();


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject obj = myJSON(response);
                        fullnameTextView.setText("Name: " + obj.optString("name"));
                        usernameTextView.setText("Username: " + obj.optString("username"));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                BreakIterator errorTextView;
                errorTextView.setText("That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);


    }

    /*JSON paarse customize */
    public JSONObject myJSON(String response) {
        JSONObject obj = null;
        try {
            obj = new JSONObject(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return obj;
    }
}
