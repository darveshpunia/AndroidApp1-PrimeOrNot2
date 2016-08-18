package com.example.darvesh.primeornot;

import android.content.res.Configuration;
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
    TextView randText, yourScore, totalScore;
    //min, max variables for setting the lower and upper range for the random function
    int min = 1, max=1000;
    RelativeLayout rL;
    Random random = new Random();
    //Variable for Random number, which will be used throughout the code
    int globalRandom, globalColor=-1, globalYourScore=0, globalTotal=0;

    static final String GLOBAL_RANDOM = "gRandom", RANDOM_COLOR = "rColor", GSCORE = "yourScore", TSCORE="totalScore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prime = (Button) findViewById(R.id.button);
        skip = (Button) findViewById(R.id.button3);
        notPrime = (Button) findViewById(R.id.button2);
        randText = (TextView) findViewById(R.id.textView);
        rL = (RelativeLayout) findViewById(R.id.relativeLayout);
        //Handling button clicks by implementing OnClickListener
        prime.setOnClickListener(this);
        skip.setOnClickListener(this);
        notPrime.setOnClickListener(this);

        yourScore = (TextView) findViewById(R.id.yourScore);
        totalScore = (TextView) findViewById(R.id.outOfScore);

        //call if some data is present in savedInstanceState, which would be saved during screen rotation
        if (savedInstanceState != null) {
            //getting all the saved data, before rotation
            globalRandom = savedInstanceState.getInt(GLOBAL_RANDOM);
            randText.setText("" + globalRandom);
            globalColor = savedInstanceState.getInt(RANDOM_COLOR);
            globalTotal = savedInstanceState.getInt(TSCORE);
            globalYourScore = savedInstanceState.getInt(GSCORE);
            //setting data if it was modified before rotation
            if(globalColor!=-1){
                //assigning the layout a random color
                rL.setBackgroundColor(globalColor);
            }
            if(globalYourScore!=0){
                yourScore.setText("" + globalYourScore);
            }
            if(globalTotal!=0){
                totalScore.setText("" + globalTotal);
            }
        }
        else {
            globalRandom = random.nextInt(max - min) + min;
            randText.setText("" + globalRandom);
        }
    }

    // Function to handle data on orientation change.
    @Override
    protected void onSaveInstanceState (Bundle savedInstanceState) {
        //saving random number before orientation change
        savedInstanceState.putInt(GLOBAL_RANDOM, globalRandom);
        //saving random color before orientation change
        savedInstanceState.putInt(RANDOM_COLOR, globalColor);
        //saving user's score before orientation change
        savedInstanceState.putInt(GSCORE, globalYourScore);
        //saving total questions attempted by user before orientation change
        savedInstanceState.putInt(TSCORE, globalTotal);
        super.onSaveInstanceState(savedInstanceState);
    }

    /* Function to handle Prime Number Logic */
    public static boolean CheckPrime (int pNum){
        int check, n, i;
        n = pNum;
        boolean prime=true;
        for(i=2;i<=n/2;i++){
            check=n%i;
            if(check==0){
                prime=false;
                break;
            }
        }
       return prime;
    }

    /* Function to handle multiple Clicks, using switch case */
    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button: {    // case to handle when the user taps on the button "Prime"
                if(CheckPrime(globalRandom)) {
                    //Toast to display correct or incorrect based on response
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_LONG).show();
                    //keeping track of current score of user, so geting the value and adding 1 to it, since it's a correct answer
                    globalYourScore = Integer.valueOf(yourScore.getText().toString());
                    globalYourScore = globalYourScore+1;
                    yourScore.setText("" + globalYourScore);
                }else{
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();
                }
                globalRandom = random.nextInt(max - min) + min;
                randText.setText("" + globalRandom);
                globalTotal = Integer.valueOf(totalScore.getText().toString());
                globalTotal = globalTotal+1;
                totalScore.setText("" + globalTotal);
                //random color number generation
                globalColor = Color.argb(random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextInt(256));
                //assigning the layout a random color
                rL.setBackgroundColor(globalColor);
                break;
            }
            case R.id.button2: {  // case to handle when the user taps on the button "Prime"
                if(!CheckPrime(globalRandom)) {
                    //Toast to display correct or incorrect based on response
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_LONG).show();
                    //keeping track of current score of user, so geting the value and adding 1 to it, since it's a correct answer
                    globalYourScore = Integer.valueOf(yourScore.getText().toString());
                    globalYourScore = globalYourScore+1;
                    yourScore.setText("" + globalYourScore);
                }else{
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_LONG).show();
                }
                globalRandom = random.nextInt(max - min) + min;
                randText.setText("" + globalRandom);
                globalTotal = Integer.valueOf(totalScore.getText().toString());
                globalTotal = globalTotal+1;
                totalScore.setText("" + globalTotal);
                globalColor = Color.argb(random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextInt(256));
                rL.setBackgroundColor(globalColor);
                break;
            }
            case R.id.button3: {     // case to handle when the user taps on the button "Skip"
                globalRandom = random.nextInt(max - min) + min;
                randText.setText("" + globalRandom);
                //random color number generation
                globalColor = Color.argb(random.nextInt(256), random.nextInt(256), random.nextInt(256), random.nextInt(256));
                //assigning the layout a random color
                rL.setBackgroundColor(globalColor);
                break;
            }
        }
    }
}
