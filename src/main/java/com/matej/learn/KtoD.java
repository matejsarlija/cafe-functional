package com.matej.learn;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

// key to disk utility
public class KtoD {
    public static void main(String[] args) {
        String str;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter text ('stop' to quit).");

        try (FileWriter fw = new FileWriter("test.txt")) {
            do {
                System.out.print("Line:");
                str = br.readLine();

                if (str.compareTo("stop") == 0) break;
                
                str = str + "\r\n"; // add newline
                fw.write(str); // write strings to file
            } while (str.compareTo("stop") != 0);
        } catch (Exception e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
