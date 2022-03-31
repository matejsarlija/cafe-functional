package com.matej.learn;

public class QueueFullException extends Exception {
    int size;

    QueueFullException(int s) { size = s;}

    public String toString() {
        return "\n Queue is full. Maximum size is " + size;
    }
}
