package com.callmejo.httpapplication;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
import java.util.HashMap;
import java.util.Map;

import my.custom.definition.UrlNames;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void myProfile(View view) {
        RequestQueue mRequestQueue = Volley.newRequestQueue(this); // 'this' is Context

//        final String URL = "http://jomon-mybc.rhcloud.com/api/v1/bloodgroups";

// pass second argument as "null" for GET requests
        JsonObjectRequest req = new JsonObjectRequest(UrlNames.URL_BLOOD_GROUPS, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Toast.makeText(getApplicationContext(), response.toString(4), Toast.LENGTH_LONG).show();
//                            VolleyLog.v("Response:%n %s", response.toString(4));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.e("Error: ", error.getMessage());
            }
        });

// add the request object to the queue to be executed
        ApplicationController.getInstance().addToRequestQueue(req);
    }


    public void signlop(View view) {
        Map<String, String> params = new HashMap<String, String>();
//        jsonParams.put("param1", youParameter);

//        StringRequest req = new StringRequest(URL, new Response.Listener<String>(){
//
//        }

        params.put("email", "jomon@gmail.com");
        params.put("password", "a@12345");
        params.put("name", "Jomon");
        params.put("contact_number", "9495367667");
        params.put("gender", "2");
        params.put("dob", "10-12-1986");
        params.put("blood_group", "5");
        params.put("hb_count", "13");
        params.put("latitude", "9.9653689");
        params.put("longitude", "76.30716939999999");
        params.put("place_name", "Chilavannur Road, Chilavannur");

        JsonObjectRequest myRequest = new JsonObjectRequest(
                Request.Method.POST,
                UrlNames.URL_TEST_POST,
                new JSONObject(params),

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
//                        verificationSuccess(response);
                        Log.e("Sucess : : ", response.toString());
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                        verificationFailed(error);\
                        String error1 = error.toString();
                        Log.e("Error: ", "" + error1.toString());
                    }

                }

        )

        {

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
//                headers.put("User-agent", "My useragent");
                return headers;
            }

            //

            //
        };
        ApplicationController.getInstance().

                addToRequestQueue(myRequest, "tag");


    }

    /*

     */

    public void signUpGet(View view) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
//        RequestQueue queue = VolleySingleton.getsInstance().getRequestQueue();


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, UrlNames.URL_TEST_GET,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
//                        JSONObject obj = myJSON(response);
                        Log.e("RESPO:", response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                BreakIterator errorTextView;
                Log.e("RESPO:", "That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);


    }

    public void signUp(View view) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, UrlNames.URL_TEST_POST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject obj = myJSON(response);

                        try {
                            Log.e("RESPO:", obj.getString("name"));
                            Log.e("RESPO:", String.valueOf(obj.getInt("mobile")));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                BreakIterator errorTextView;
                Log.e("RESPO:", "That didn't work!");
            }
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "JMJ");
                params.put("mobile", "12336");
                return params;
            }

        };
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
