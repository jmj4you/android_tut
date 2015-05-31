package com.callmejo.httpapplication;

import android.app.Activity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;

import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import in.jmj.webservice.Api;
import in.jmj.webservice.MyKeyValueList;

public class MainActivity extends Activity {

    public static EditText editText_name, editText_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_name = (EditText) findViewById(R.id.editText_name);
        editText_email = (EditText) findViewById(R.id.editText_email);
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
                        JSONObject responseObj = API.parseMyResponse(MainActivity.this, response);
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
                        JSONObject obj = API.toJSON(response);
                        try {
                            String resultArray = obj.getString("result");
                            JSONObject objResult = API.toJSON(resultArray);
                            if (objResult.getString("status").equals("fail")) {
//                                Log.e("ERROR_>", "FAILED");
                                String error_title = objResult.getString("message");
                                String error_string = objResult.getString("error");
                                JSONObject objError = API.toJSON(error_string);

                                if (objError.has("email"))
                                    editText_email.setError(objError.getString("email"));
                                if (objError.has("name"))
                                    editText_name.setError(objError.getString("name"));

                            }

                        } catch (JSONException e) {
                            Log.e("Err: ", e.toString());
                            e.printStackTrace();

                        }

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
//                params.put("email", "jomon@gmail.com");
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
