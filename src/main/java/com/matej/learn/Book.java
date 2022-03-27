package com.matej.learn;

public class Book {
    String ISBN;

    public String getISBN() {
        return ISBN;
    }

    public boolean equals(Book obj) {
        if (obj instanceof Book) {
            return ISBN.equals(obj.getISBN());
        } else {
            return false;
        }
    }
}
