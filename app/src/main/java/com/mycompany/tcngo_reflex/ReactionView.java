/*
Copyright 2015 Theresa Ngo

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.mycompany.tcngo_reflex;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileOutputStream;

/**
 * Created by Theresa Ngo on 04-10-15.
 */

// This activity is the main part of the Reaction Time game
public class ReactionView extends AppCompatActivity {

    // Initialize save file and count down timer
    private CountDownTimer count;
    private static final String FILENAME = "reaction.sav";

    // Create file
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_view);

        // Popup menu with instructions
        AlertDialog.Builder intro = new AlertDialog.Builder(ReactionView.this);
        intro.setTitle("Reaction timer instructions");
        intro.setMessage("Press the button when it says 'Click!!'." +
                "Begin when this message closes.");

        // Counter between 10ms to 2000ms begins after dialog box is closed
        intro.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int choice) {
                        dialog.dismiss();
                        count.start();
                    }
                }
        );
        intro.show();

    }

    // Start file
    @Override
    protected void onStart(){
        super.onStart();

        // Define button variable and connect to its interface
        final Button button = (Button) findViewById(R.id.clickButton);

        // Set the button to tell the user to wait
        button.setText("Wait...");

        // Calls GenerateTime class to determine the amount of waiting time
        GenerateTime seconds = new GenerateTime();
        int wait = seconds.RandomTime();

        // Initializes counter
        count = new CountDownTimer(wait,1) {

            // Function of the counter while it is counting down
            @Override
            public void onTick(long millisUntilFinished) {

                // Waits for button in case it is pressed early
                button.setOnClickListener(new View.OnClickListener() {

                    // If the button is pressed too early
                    @Override
                    public void onClick(View v) {

                        // Popup window to inform the user and restart the game
                        AlertDialog.Builder early = new AlertDialog.Builder(ReactionView.this);
                        early.setTitle("Error");
                        early.setMessage("That was too early.");
                        early.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int choice) {
                                        button.setText("Wait...");
                                        dialog.dismiss();
                                        cancel();
                                        start();
                                    }
                                }
                        );
                        early.show();
                    }
                });
            }

            // After the countdown is complete
            @Override
            public void onFinish() {

                // Change button text to prompt user to click
                button.setText("Click!!");

                // Record starting time
                final long startTime = System.currentTimeMillis();

                // Waits for button to be pressed
                button.setOnClickListener(new View.OnClickListener() {

                    // When the button is clicked
                    @Override
                    public void onClick(View v) {

                        // Record the end time and calculate the reaction time
                        long endTime = System.currentTimeMillis();
                        long totalTime = endTime - startTime;
                        int intTotalTime = (int) totalTime;

                        // Save the reaction time into the file
                        setResult(RESULT_OK);
                        saveInFile(intTotalTime, getApplicationContext());

                        // Popup menu to return result and restart the game
                        AlertDialog.Builder result = new AlertDialog.Builder(ReactionView.this);
                        result.setTitle("Result");
                        result.setMessage("Time taken: " + (intTotalTime) + " ms");
                        result.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int choice) {
                                        dialog.dismiss();
                                        Intent intent = getIntent();
                                        finish();
                                        startActivity(intent);
                                    }
                                }
                        );
                        result.show();
                    }
                });

            }
        };

    }

    // Function for saving the file
    private void saveInFile(int time, Context con){
        try {
            FileOutputStream fos = con.openFileOutput(FILENAME, 0);
            fos.write(String.valueOf(time).getBytes());
            fos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
