package com.example.jomon.gmapapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void process(View view) {
        Intent intent = null,chooser=null;

        if (view.getId() == R.id.button_gmap) {
            intent = new Intent(Intent.ACTION_VIEW);
//            elamkulam
            intent.setData(Uri.parse("geo:9.9653689,76.30716939999999"));
            chooser=intent.createChooser(intent,"Launch Map");
            startActivity(chooser);

        }
    }
}
