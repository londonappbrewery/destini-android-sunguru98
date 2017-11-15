package com.londonappbrewery.destini;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView storyTextView;
    private Button topButton,bottomButton;
    private int topLevel,bottomLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            topLevel = savedInstanceState.getInt("topLevel");
            bottomLevel = savedInstanceState.getInt("bottomLevel");
        }
        else {

            topLevel = 1;
            bottomLevel = 1;

        }

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        storyTextView = (TextView)findViewById(R.id.storyTextView);
        topButton = (Button)findViewById(R.id.buttonTop);
        bottomButton=(Button)findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(topLevel == 1){
                    topLevel++;
                    storyTextView.setText(R.string.T3_Story);
                    topButton.setText(R.string.T3_Ans1);
                    bottomButton.setText(R.string.T3_Ans2);
                }
                else if(topLevel == 2){
                    storyTextView.setText(R.string.T6_End);
                    topButton.setEnabled(false);
                    bottomButton.setEnabled(false);
                    topButton.setVisibility(View.INVISIBLE);
                    bottomButton.setVisibility(View.INVISIBLE);
                }

                if(bottomLevel == 2){
                    bottomLevel++;
                    storyTextView.setText(R.string.T3_Story);
                    topButton.setText(R.string.T3_Ans1);
                    bottomButton.setText(R.string.T3_Ans2);

                }
                else if(bottomLevel==3){
                    storyTextView.setText(R.string.T6_End);
                    topButton.setEnabled(false);
                    bottomButton.setEnabled(false);
                    topButton.setVisibility(View.INVISIBLE);
                    bottomButton.setVisibility(View.INVISIBLE);
                }

            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (topLevel == 2) {
                    storyTextView.setText(R.string.T5_End);
                    System.out.println("came here");
                    topButton.setEnabled(false);
                    bottomButton.setEnabled(false);
                    topButton.setVisibility(View.INVISIBLE);
                    bottomButton.setVisibility(View.INVISIBLE);
                }
                else
                    {
                    if (bottomLevel == 1) {
                        bottomLevel++;
                        storyTextView.setText(R.string.T2_Story);
                        topButton.setText(R.string.T2_Ans1);
                        bottomButton.setText(R.string.T2_Ans2);
                    } else if (bottomLevel == 2) {
                        storyTextView.setText(R.string.T4_End);
                        topButton.setEnabled(false);
                        bottomButton.setEnabled(false);
                        topButton.setVisibility(View.INVISIBLE);
                        bottomButton.setVisibility(View.INVISIBLE);
                    } else if (bottomLevel == 3) {
                        storyTextView.setText(R.string.T5_End);
                        topButton.setEnabled(false);
                        bottomButton.setEnabled(false);
                        topButton.setVisibility(View.INVISIBLE);
                        bottomButton.setVisibility(View.INVISIBLE);
                    }

                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("topLevel",topLevel);
        outState.putInt("bottomLevel",bottomLevel);
    }
}
