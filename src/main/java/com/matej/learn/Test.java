package com.matej.learn;

public class Test {
    int a;

    Test(int i) {
        a = i;
    }

    /* Pass an object. Now, ob.a and ob.b in object
    used in the call will be changed. */
    void change(Test ob) {
        int temp;
        temp = ob.a;
        ob.a = this.a;
        this.a = temp;


    }

}
