package com.callmejo.myapp2;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

    private TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*

         */

        setContentView(R.layout.activity_display_message);

        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra("TXT_MESSAGE");

        tv=(TextView)findViewById(R.id.txt_view);
        tv.setText(message);

    }


}