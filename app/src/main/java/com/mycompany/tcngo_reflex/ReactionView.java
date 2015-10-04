package com.mycompany.tcngo_reflex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ReactionView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_view);

        Intent intent = new Intent(this, ReactionPopUp.class);
        startActivity(intent);
    }

    public void onStart(){
        super.onStart();
        Intent intent = new Intent(this, ReactionPopUp.class);
        startActivity(intent);
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void game_start(){
        // http://tutorials.jenkov.com/android/buttons.html
        final Button button;
        button = (Button)findViewById(R.id.clickButton);

        try {
            Timer start_time = new Timer();
            button.setText("Starting...");
            synchronized (this) {
                this.wait(start_time.RandomTime());
            }
            //ReactionView.this.onEarlyClick();

        } catch (Exception e) {
            button.setText("Too Early!");
            //ReactionView.this.onEarlyClick();
        }

        try {
            Timer time = new Timer();
            button.setText("Wait");
            synchronized (this) {
                this.wait(time.RandomTime());
            }
            button.setText("Click!");

            //ReactionView.this.onEarlyClick();

        } catch (Exception e) {
            button.setText("Too Early!");
            //ReactionView.this.onEarlyClick();
        }

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                button.setText("Clicked");

            }

        });

        // The activity has become visible (it is now "resumed").
    }

    public void onEarlyClick(){
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
        // Another activity is taking focus (this activity is about to be "paused").
    }
    @Override
    protected void onStop() {
        super.onStop();
        // The activity is no longer visible (it is now "stopped")
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // The activity is about to be destroyed.
    }

}
