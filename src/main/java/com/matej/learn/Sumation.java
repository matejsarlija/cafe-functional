package com.matej.learn;

public class Sumation {
    int sum;

    // Construct from an int.
    Sumation(int num) {
        sum = 0;
        for(int i = 1; i <= num; i++) {
            sum += i;
        }
    }

    // Construct from another object
    Sumation(Sumation ob) {
        sum = ob.sum;
    }
}
