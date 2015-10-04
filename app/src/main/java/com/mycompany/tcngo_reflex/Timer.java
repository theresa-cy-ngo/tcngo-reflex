package com.mycompany.tcngo_reflex;

import java.util.Random;

/**
 * Created by Owner on 10/4/2015.
 */
public class Timer {
    // Chooses a random wait time between 10ms and 2000ms
    public int RandomTime() {
        Random counter = new Random();
        int timer = 10 + counter.nextInt(5000);

        return timer;
    }
}
