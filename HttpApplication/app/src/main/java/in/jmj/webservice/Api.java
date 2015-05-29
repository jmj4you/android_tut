package in.jmj.webservice;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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
import com.callmejo.httpapplication.MainActivity;

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
//    public static String URL_TEST_POST = URL_TEST_BASE + "/testPost";
//    public static String URL_TEST_GET = URL_TEST_BASE + "/testGet?jmj=65";

    final Context context;
    public JSONObject objResult;

    public Api(Context context) {
        this.context = context;
    }


    public static JSONObject toJSON(String string) {
        JSONObject obj = null;
        try {
            obj = new JSONObject(string);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public JSONObject parseMyResponse(String response) {

        JSONObject obj = toJSON(response);

        try {
            String resultArray = obj.getString("result");
            objResult = toJSON(resultArray);
//            Log.e("STS", objResult.getString("status"));

            if (objResult.getString("status").equals("fail")) {
//                Log.e("ERROR_>", "FAILED");
                String error_title = objResult.getString("message");
                String error_string = objResult.getString("error");

                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                alert.setTitle(error_title);
                alert.setMessage(error_string);
                alert.setPositiveButton("OK", null);
                alert.show();
            }

        } catch (JSONException e) {
            Log.e("Err: ", e.toString());
            e.printStackTrace();

        }
        return objResult;
    }


}

