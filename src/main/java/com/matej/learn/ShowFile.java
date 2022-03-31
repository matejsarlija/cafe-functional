package com.matej.learn;

import java.io.*;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;;

        // First make sure that a file has been specified.
        if(args.length != 1) {
            System.out.println("Usage: ShowFile file");
            return;
        } 

        try {
            fin = new FileInputStream(args[0]);

            do {
                i = fin.read();
                if ( i != -1) System.out.println((char) i);

            } while (i != -1);
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
            return;

        } finally {
            try {
                if (fin != null) fin.close();
            } catch (IOException exc) {
                System.out.println("Error closing the file.");
            }
        }
    }
}
