package com.matej.learn;

public class MultiCatch {
    public static void main(String[] args) {
        int a = 88;
        int b = 0;
        int result;
        char[] chrs = {'A', 'B', 'C'};

        for(int i = 0; i < 2; i++) {
            try {
                if(i == 0) result = a / b; // Generates an ArithmeticException
                else chrs[5] = 'X'; // Generate an ArrayOutOfBondsException
            } catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Exception caught: " + e);
            }
        }

        System.out.println("After multi-catch.");
    }
}
