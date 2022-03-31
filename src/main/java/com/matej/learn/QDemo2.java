package com.matej.learn;

class Queue {
    char[] q; // array that holds the queue
    int putloc, getloc; // the put and get indices

    Queue(int size) {
        q = new char[size]; // allocate memory for our queue
        putloc = getloc = 0;
    }

    Queue(Queue ob) {
        putloc = ob.putloc;
        getloc = ob.getloc;
        q = new char[ob.q.length];

        // copy elements
        for(int i = getloc; i < putloc; i++) {
            q[i] = ob.q[i];
        }
    }

    Queue(char[] a) {
        putloc = 0;
        getloc = 0;

        q = new char[a.length];

        for(int i = 0; i < a.length; i++) put (a[i]);
    }

    // puts a character into the queue
    void put(char ch) {
        if(putloc == q.length) {
            System.out.println(" - Queue is full");
            return;
        }

        q[putloc++] = ch;
    }

    // gets a character from the queue
    char get() {
        if(getloc == putloc) {
            System.out.println(" - Queue is empty.");
            return (char) 0;
        }

        return q[getloc++];
    }
}

class QDemo {
    
    public static void main(String[] args) {
        Queue bigQueue = new Queue(100);
        Queue smallQueue = new Queue(4);
        char ch;
        int i;

        System.out.println("Using bigQ to store the alphabet.");
        // put some numbers into bigQ
        for(i = 0; i< 26; i++) {
            bigQueue.put((char) ('A' + i));
        }

        // retrieve and display elements from bigQ
        System.out.println("Contents of bigQ: ");
        for(i = 0; i < 26; i++) {
            ch = bigQueue.get();
            if(ch != (char) 0) System.out.print(ch);
        }

        System.out.println("\n");

        System.out.println("Using smallQ to generate errors");

        // now use smallQ to generate some errors
        for(i = 0; i < 5; i++) {
            System.out.println("Attempting to store " + (char) ('Z' - i));
            smallQueue.put((char) ('Z' - i));

            System.out.println();
        }

        


    }
}
