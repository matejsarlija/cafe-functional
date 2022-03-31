package com.matej.learn;

import java.io.*;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        

        // First make sure that a file has been specified.
        if(args.length != 1) {
            System.out.println("Usage: ShowFile file");
            return;
        } 

        try (FileInputStream fin = new FileInputStream(args[0])){
            
            do {
                i = fin.read();
                if ( i != -1) System.out.println((char) i);

            } while (i != -1);

        } catch (IOException e) {
            System.out.println("I/O error: " + e);
            return;
        } 
    }
}
