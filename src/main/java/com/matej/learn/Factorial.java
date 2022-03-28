package com.matej.learn;

public class Factorial {
    
    // this is a recursive function.
    int factorialRecursive(int n) {
        int result;

        if (n == 1) return 1;
        result = factorialRecursive(n-1) * n;
        return result;
    }

    int factorialIterative(int n) {
        int t;
        int result;

        result = 1;

        for (t = 1; t <= n; t++) result *= t;
        return result; 
    }
}
