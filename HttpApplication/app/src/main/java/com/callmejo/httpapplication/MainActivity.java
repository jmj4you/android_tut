package com.callmejo.httpapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import in.jmj.webservice.Api;
import in.jmj.webservice.MyKeyValueList;

public class MainActivity extends Activity {

    public EditText editText_name, editText_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_name = (EditText) findViewById(R.id.editText_name);
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


    public void apiGet(View view) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        // API object
        final Api API = new Api(this);

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                Api.URL_BLOOD_GROUPS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String resp_msg = "";
                        JSONObject responseObj = API.parseMyResponse(response);
                        try {
                            resp_msg = responseObj.getString("message");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        Toast.makeText(getApplicationContext(), resp_msg, Toast.LENGTH_LONG).show();
/*
Do your Code here
 */
                    }
                }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                BreakIterator errorTextView;
                Toast.makeText(getApplicationContext(), "Please try again later!", Toast.LENGTH_LONG).show();

            }
        }
        );
// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }


    public void apiPost(final View view) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
// API object
        final Api API = new Api(this);
// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Api.URL_SIGNUP,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("respo:", response);
                        JSONObject reponseObj = API.parseMyResponse(response);


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                BreakIterator errorTextView;
                Toast.makeText(getApplicationContext(), "Please try again later!", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
//                params.put("name", "JMJ");
//                params.put("mobile", "12336");
                params.put("email", "jomon@gmail.com");
                params.put("password", "a@12345");
//                params.put("name", "Jomon");
//                params.put("contact_number", "9495367667");
//                params.put("gender", "2");
//                params.put("dob", "10-12-1986");
                params.put("blood_group", "5");
                params.put("hb_count", "13");
                params.put("latitude", "9.9653689");
                params.put("longitude", "76.30716939999999");
                params.put("place_name", "Chilavannur Road, Chilavannur");
                return params;
            }

        };
        // Add the request to the RequestQueue.
        queue.add(stringRequest);


    }


    public void validateName(View view) {

        editText_name.setError("Field cannot be left blank.");
    }


}
