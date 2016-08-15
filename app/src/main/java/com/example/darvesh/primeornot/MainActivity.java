package com.example.darvesh.primeornot;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button prime, skip, notPrime;
    TextView randText;
    int min = 1, max=1000;
    RelativeLayout rL;
    Random random = new Random();
    int globalRandom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prime = (Button) findViewById(R.id.button);
        skip = (Button) findViewById(R.id.button3);
        notPrime = (Button) findViewById(R.id.button2);
        randText = (TextView) findViewById(R.id.textView);
        rL = (RelativeLayout) findViewById(R.id.relativeLayout);
        prime.setOnClickListener(this);
        skip.setOnClickListener(this);
        notPrime.setOnClickListener(this);

    }

    public static boolean CheckPrime (int pNum){
        int temp;
        boolean isPrime=true;
        int num = pNum;
        for(int i=2;i<=num/2;i++)
        {
            temp=num%i;
            if(temp==0)
            {
                isPrime=false;
                break;
            }
        }
       return isPrime;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button3: {
                globalRandom = random.nextInt(max - min) + min;
//                Toast.makeText(getApplicationContext(), "Random: "+k, Toast.LENGTH_LONG).show();
                randText.setText("" + globalRandom);

                int color = Color.argb(random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextInt(256));

                rL.setBackgroundColor(color);

                break;
            }
            case R.id.button2: {
                if(!CheckPrime(globalRandom)) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();
                }
                break;
            }
            case R.id.button: {
                if(CheckPrime(globalRandom)) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }
}
