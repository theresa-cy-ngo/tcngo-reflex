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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Theresa Ngo on 04-10-15.
 */

// This activity is to show the reaction time from the Reaction Time game
    // This area is mostly incomplete
public class ReactionStat extends AppCompatActivity {

    // Initialize the save files and list from the files
    private static final String FILENAME = "reaction.sav";
    private ListView reaction_list;
    MeasureStat measure = new MeasureStat();

    // Create file
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_stat);
        reaction_list = (ListView) findViewById(R.id.min10List);
    }

    // Load the files onto an ArrayAdapter
    @Override
    protected void onStart() {
        super.onStart();
        String[] times = loadFromFile();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                R.layout.list_item, times);
        reaction_list.setAdapter(adapter);
    }

    // Class to load the array from the file
    private String[] loadFromFile() {
        ArrayList<String> times = new ArrayList<>();
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            String line = in.readLine();
            while (line != null) {
                times.add(line);
                line = in.readLine();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return times.toArray(new String[times.size()]);
    }
}
