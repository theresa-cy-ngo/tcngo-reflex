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

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Theresa Ngo on 04-10-15.
 */

// This activity is the view for the Gameshow menu to ask for the number of players
public class BuzzerMenuView extends AppCompatActivity {

    // Create file
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzzer_menu_view);
    }

    // Two players chosen
    public void gameTwo(View view){
        Intent intent = new Intent(this, BuzzerTwo.class);
        startActivity(intent);

    }

    // Three players chosen
    public void gameThree(View view){
        Intent intent = new Intent(this, BuzzerThree.class);
        startActivity(intent);

    }

    // Four players chosen
    public void gameFour(View view){
        Intent intent = new Intent(this, BuzzerFour.class);
        startActivity(intent);

    }
}
