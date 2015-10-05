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

import java.util.Random;

/**
 * Created by Theresa Ngo on 04-10-15.
 */

// This class is to generate a random time between 10ms to 2000ms
public class GenerateTime {

    // Chooses a random wait time between 10ms and 2000ms
    public int RandomTime() {
        Random counter = new Random();
        int timer = 10 + counter.nextInt(1990);

        return timer;
    }

}
