package com.callmejo.myholo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    private Button click_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click_button= (Button) findViewById(R.id.click_button);
        click_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Its working fine!",Toast.LENGTH_LONG).show();

            }
        });
    }
// Have to add setOnClickListener for that button
//    public void clickMe(View view){
//        Toast.makeText(getApplicationContext(),"Its working fine!",Toast.LENGTH_LONG).show();
//    }
}
