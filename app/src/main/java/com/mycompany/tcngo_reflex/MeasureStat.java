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

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Theresa Ngo on 04-10-15.
 */

// This class is for calculating the statistics in the Statistics menu
    // The calculations are mostly complete but its implementation in other classes is not.
public class MeasureStat {

    // Returns the last ten items of an array
    public ArrayList<String> lastTen(ArrayList<String> arrays){

        // Define the array to be returned
        ArrayList<String> arrayTen = new ArrayList<>();

        // Find the last ten items of the array
        if (arrays.size() >= 10){

            for (int i = 0; i < 10; i++){
                arrayTen.add(arrays.get(arrays.size() - i));
            }
        } else {
            // Uses the whole array if ten or less items
            arrayTen = arrays;
        }

        return arrayTen;
    }

    // Returns the last one hundred items of an array
    public ArrayList<String> lastHun(ArrayList<String> arrays){

        // Define the array to be returned
        ArrayList<String> arrayHun = new ArrayList<>();

        // Find the last one hundred items of the array
        if (arrays.size() >= 100){

            for (int i = 0; i < 10; i++){
                arrayHun.add(arrays.get(arrays.size() - i));
            }
        } else {
            // Uses the whole array if one hundred or less items
            arrayHun = arrays;
        }

        return arrayHun;
    }

    // Returns the minimum value of a number of items in an array
    public int minTime(ArrayList<String> arrays){

        // Initialize minimum
        int minimum = 10000000;

        // Iterate through array to find the minimum
        for (int i = 0; i < arrays.size(); i++){
            String elementStr = arrays.get(i);
            int elementInt = Integer.parseInt(elementStr);
            if (elementInt < minimum){
                minimum = elementInt;
            }
        }

        return minimum;
    }

    // Returns the maximum value of a number of items in an array
    public int maxTime(ArrayList<String> arrays){

        // Initialize maximum
        int maximum = 0;

        // Iterate through array to find maximum
        for (int i = 0; i < arrays.size(); i++){
            String elementStr = arrays.get(i);
            int elementInt = Integer.parseInt(elementStr);
            if (elementInt > maximum){
                maximum = elementInt;
            }

        }

        return maximum;
    }

    // Returns the average value of a number of items in an array
    public int avgTime(ArrayList<String> arrays){

        // Initializes the sum
        int sum = 0;

        // Iterates through the array to add to the sum
        for (int i = 0; i < arrays.size(); i++){
            String elementStr = arrays.get(i);
            int elementInt = Integer.parseInt(elementStr);
            sum = sum + elementInt;
        }

        // Calculate the average
        double averageD = sum/arrays.size();
        int averageI = (int)(averageD);

        return averageI;
    }

    // Returns the median value in the number of items in an array
    public int medTime(ArrayList<String> arrays) {

        // Initialize the array of integers
        ArrayList<Integer> arrayInt = new ArrayList<>();

        // Iterate through the array to create an integer array
        for (int i = 0; i < arrays.size(); i++){
            String elementStr = arrays.get(i);
            int elementInt = Integer.parseInt(elementStr);
            arrayInt.add(elementInt);
        }

        // Sort the new integer array
        Collections.sort(arrayInt);

        // Find the middle point
        int middle1 = (arrays.size())/2;

        // If the size of the array is an odd number, median is the middle
        if (arrays.size() % 2 == 1){
            int median = arrayInt.get(middle1);
            return median;
        } else{
            // If it is an even number, then find the middle of the two numbers
            int middle2 = middle1 - 1;
            int median = ((arrayInt.get(middle1)) + (arrayInt.get(middle2))) / 2;
            return median;
        }
    }

    // Counts the number of each win based on the number of players
    public ArrayList<Integer> countWin (ArrayList<String> arrays, int players) {

        // Create a new integer array
        ArrayList<Integer> intArray = new ArrayList<>();

        // Initialize counters
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;

        // Count the number of wins for each player
        for (int i = 0; i < arrays.size(); i++){
            if (arrays.get(i) == "Player 1 buzzes"){
                count1++;
            } else if (arrays.get(i) == "Player 2 buzzes"){
                count2++;
            } else if (arrays.get(i) == "Player 3 buzzes"){
                count3++;
            } else if (arrays.get(i) == "Player 4 buzzes"){
                count4++;
            }
        }

        // Add the sums to the integer array
        intArray.add(count1);
        intArray.add(count2);

        if (players == 3){
            intArray.add(count3);
        } else if (players == 4){
            intArray.add(count4);
        }

        return intArray;
    }
}
