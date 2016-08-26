package com.example.darvesh.primeornot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class CheatShowActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat_show);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int value = getIntent().getIntExtra("randomNum", 0);
        String ans = getIntent().getStringExtra("randomNumAns");

        tv = (TextView) findViewById(R.id.textView6);
        tv.setText(""+value+" is a "+ans+" number");
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return true;
    }
}
