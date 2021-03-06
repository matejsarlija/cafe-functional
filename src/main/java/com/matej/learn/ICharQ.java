package com.matej.learn;

public interface ICharQ {
    // put a character into the queue
    void put(char ch) throws QueueFullException;

    // get a character from the queue
    char get() throws QueueEmptyException;
}
