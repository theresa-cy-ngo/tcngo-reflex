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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileOutputStream;

/**
 * Created by Theresa Ngo on 04-10-15.
 */

// This activity is for the Gameshow mode with four players
public class BuzzerFour extends AppCompatActivity {

    // Initialize save file
    private static final String FILENAME = "gameFour.sav";

    // Create file
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzzer_four);
    }

    // Start file
    @Override
    protected void onStart(){
        super.onStart();

        // Define button variables to their interface
        final Button button1 = (Button) findViewById(R.id.first_button);
        final Button button2 = (Button) findViewById(R.id.second_button);
        final Button button3 = (Button) findViewById(R.id.third_button);
        final Button button4 = (Button) findViewById(R.id.fourth_button);

        // If player 1 presses first
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Popup menu appears to return result
                AlertDialog.Builder end1 = new AlertDialog.Builder(BuzzerFour.this);
                end1.setTitle("Result");
                end1.setMessage("The winner is: Player 1");

                // Saves the string into the file
                String win = "Player 1 buzzes";
                setResult(RESULT_OK);
                saveInFile(win);

                // Restart game
                end1.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int choice) {
                                dialog.dismiss();
                                Intent intent = getIntent();
                                finish();
                                startActivity(intent);
                            }
                        }
                );
                end1.show();
            }
        });

        // If player 2 presses first
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Popup menu appears to return result
                AlertDialog.Builder end2 = new AlertDialog.Builder(BuzzerFour.this);
                end2.setTitle("Result");
                end2.setMessage("The winner is: Player 2");

                // Saves the string into the file
                String win = "Player 2 buzzes";
                setResult(RESULT_OK);
                saveInFile(win);

                // Restart game
                end2.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int choice) {
                                dialog.dismiss();
                                Intent intent = getIntent();
                                finish();
                                startActivity(intent);
                            }
                        }
                );
                end2.show();
            }
        });

        // If player 3 presses first
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Popup menu appears to return result
                AlertDialog.Builder end3 = new AlertDialog.Builder(BuzzerFour.this);
                end3.setTitle("Result");
                end3.setMessage("The winner is: Player 3");

                // Saves the string into the file
                String win = "Player 3 buzzes";
                setResult(RESULT_OK);
                saveInFile(win);

                // Restart game
                end3.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int choice) {
                                dialog.dismiss();
                                Intent intent = getIntent();
                                finish();
                                startActivity(intent);
                            }
                        }
                );
                end3.show();
            }
        });

        // If player 4 presses first
        button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                // Popup menu appears to return result
                AlertDialog.Builder end4 = new AlertDialog.Builder(BuzzerFour.this);
                end4.setTitle("Result");
                end4.setMessage("The winner is: Player 4");

                // Saves the string into the file
                String win = "Player 4 buzzes";
                setResult(RESULT_OK);
                saveInFile(win);

                // Restart game
                end4.setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int choice) {
                                dialog.dismiss();
                                Intent intent = getIntent();
                                finish();
                                startActivity(intent);
                            }
                        }
                );
                end4.show();
            }
        });

    }

    // Function for saving the file
    private void saveInFile(String winner){
        try {
            FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_APPEND);
            fos.write(winner.getBytes());
            fos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
