package com.matej.learn;

public class Block {
    int a, b, c;
    int volume;

    Block(int i, int j, int k) {
        a = i;
        b = j;
        c = k;

        volume = a * b * c;
    }

    // return true if ob defines the same block.
    // ob.a je njegov, "obični" a je naš
    boolean sameBlock(Block ob) {
        if((ob.a == a) & (ob.b == b) & (ob.c == c)) return true;
        else return false; 
    }
   
    // Return true if ob has same volume.
    boolean sameVolume(Block ob) {
        if(ob.volume == volume) return true;
        else return false;
    }    
}
