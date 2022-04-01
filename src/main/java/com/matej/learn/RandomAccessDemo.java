package com.matej.learn;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessDemo {
    public static void main(String[] args) {
        double[] data = {19.4, 10.1, 123.54, 33.0, 87.9, 74.25};
        double d;

        // Open and use a random-access file
        try (RandomAccessFile raf = new RandomAccessFile("random.dat", "rw")) {

            for (int i = 0; i < data.length; i++) {
                raf.writeDouble(data[i]);
            }

            // read back specific values
            raf.seek(0); // seek to first double
            d = raf.readDouble();
            System.out.println("First value is " + d);

            raf.seek(8); // seek to second double
            d = raf.readDouble();
            System.out.println("Second value is " + d);

            raf.seek(8 * 3); // seek to fourth double
            d = raf.readDouble();
            System.out.println("Fourth value is " + d);

            // Try reading every other value
            System.out.println("Here is every other value -");
            for (int i = 0; i < data.length; i+=2) {
                raf.seek(i * 8); // seek to the i-th double
                d = raf.readDouble();
                System.out.print(d + " ");
            }
            System.out.println();

        } catch (IOException exc) {
            System.out.println("I/O Error: " + exc);
        }
    }
}
