package com.mycompany.tcngo_reflex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class BuzzerMenuView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzzer_menu_view);
    }

    public void gameTwo(View view){
        Intent intent = new Intent(this, BuzzerTwo.class);
        startActivity(intent);

    }

    public void gameThree(View view){
        Intent intent = new Intent(this, BuzzerThree.class);
        startActivity(intent);

    }

    public void gameFour(View view){
        Intent intent = new Intent(this, BuzzerFour.class);
        startActivity(intent);

    }
}
