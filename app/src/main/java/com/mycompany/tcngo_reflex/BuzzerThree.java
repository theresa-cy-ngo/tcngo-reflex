package com.mycompany.tcngo_reflex;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.FileOutputStream;

public class BuzzerThree extends AppCompatActivity {

    private static final String FILENAME = "gameThree.sav";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzzer_three);
    }

    @Override
    protected void onStart(){
        super.onStart();

        final Button button1 = (Button) findViewById(R.id.first_button);
        final Button button2 = (Button) findViewById(R.id.second_button);
        final Button button3 = (Button) findViewById(R.id.third_button);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder end1 = new AlertDialog.Builder(BuzzerThree.this);
                end1.setTitle("Result");
                end1.setMessage("The winner is: Player 1");

                String win = "Player 1 buzzes";
                setResult(RESULT_OK);
                saveInFile(win);

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

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder end2 = new AlertDialog.Builder(BuzzerThree.this);
                end2.setTitle("Result");
                end2.setMessage("The winner is: Player 2");

                String win = "Player 2 buzzes";
                setResult(RESULT_OK);
                saveInFile(win);

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

        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder end3 = new AlertDialog.Builder(BuzzerThree.this);
                end3.setTitle("Result");
                end3.setMessage("The winner is: Player 3");

                String win = "Player 3 buzzes";
                setResult(RESULT_OK);
                saveInFile(win);

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

    }

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
