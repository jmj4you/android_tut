package in.jmj.webservice;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.callmejo.httpapplication.ApplicationController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by jomon on 26/5/15.
 */
public class Api {
    public static String URL_TEST_BASE = "http://jomon-mybc.rhcloud.com/";
    public static String URL_BASE = "http://jomon-mybc.rhcloud.com/api/v1";
    public static String URL_BLOOD_GROUPS = URL_BASE + "/bloodgroups";
    public static String URL_SIGNUP = URL_BASE + "/signup";
    public static String URL_TEST_POST = URL_TEST_BASE + "/testPost";
    public static String URL_TEST_GET = URL_TEST_BASE + "/testGet?jmj=65";

    private String apiResponse;

    public static void apiGet(View view, final Context context, String url) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
/*
Do your Code here
 */
//                        return response;
                    }
                }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                BreakIterator errorTextView;
                Toast.makeText(context, "That didn't work!", Toast.LENGTH_LONG).show();

            }
        }
        );
// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

/*
POST example STRING
 */

    public static void apiPost(View view, final Context context, String url) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("respo:", response);
//
//                        JSONObject obj = null;
//                        try {
//                            obj = new JSONObject(response);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                BreakIterator errorTextView;
                Log.e("RESPO:", "That didn't work!");
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
//                params.put("name", "JMJ");
//                params.put("mobile", "12336");
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
                return params;
            }

        };
        // Add the request to the RequestQueue.
        queue.add(stringRequest);


    }

}

