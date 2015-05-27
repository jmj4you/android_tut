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

/**
 * Created by jomon on 26/5/15.
 */
public class Api {
    public static String URL_BASE = "http://jomon-mybc.rhcloud.com/api/v1";
    public static String URL_TEST_BASE = "http://jomon-mybc.rhcloud.com/";
    public static String URL_BLOOD_GROUPS = URL_BASE + "/bloodgroups";
    public static String URL_SIGNUP = URL_BASE + "/signup";
    public static String URL_TEST_POST = URL_TEST_BASE + "/testPost";
    public static String URL_TEST_GET = URL_TEST_BASE + "/testGet?jmj=65";


    public static void apiGet(View view, final Context context, String url) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("RESPO:", response);
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);
                            if (jsonObject!=null){

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }


                , new Response.ErrorListener()

        {
            @Override
            public void onErrorResponse(VolleyError error) {
//                BreakIterator errorTextView;
//                Log.e("RESPO:", "That didn't work!");
                Toast.makeText(context, "That didn't work!", Toast.LENGTH_LONG).show();
            }
        }

        );
// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }

    /*JSON paarse customize */
    private JSONObject myJSON(String response) {
        JSONObject obj = null;
        try {
            obj = new JSONObject(response);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
