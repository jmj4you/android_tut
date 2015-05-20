
#These lines should be noted
AndroidManifest.xml

<pre>
    <uses-permission android:name="android.permission.INTERNET" />
</pre>

#You have to add library for volley
 1. Download volley.jar from (https://androidtutorialmagic.wordpress.com/2015/02/03/adding-android-volley-library-in-android-studio/)
 2. Put it into app/libs
 3. Add dependencies *** compile files('libs/volley.jar') *** into build.gradle(Mobule.app)
 4. Clean and rebuild app

--------------------------------------------------------------------------------------------------------------------------------------------

MainActivity.java


<pre>
  TextView usernameTextView,fullnameTextView,errorTextView;
    String url = "http://graph.facebook.com/jmj4you";
  .....


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameTextView = (TextView) findViewById(R.id.username);
        fullnameTextView = (TextView) findViewById(R.id.fullname);
        errorTextView = (TextView) findViewById(R.id.error);
    }

   public void getMyaddress(View view) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject obj = myJSON(response);
                        fullnameTextView.setText("Name: "+ obj.optString("name"));
                        usernameTextView.setText("Username: "+ obj.optString("username"));

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

</pre>

-> Reference
Sending a Simple Request
https://developer.android.com/training/volley/simple.html

Sending a Custom Request
https://developer.android.com/training/volley/request-custom.html

# Here RequestQueue change to Singleton Queue
Volley Singleton
https://www.youtube.com/watch?v=T4SF7S6pYfE
