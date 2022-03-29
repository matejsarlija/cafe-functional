package com.matej.learn;

public class TopLevelClass {
    void accessMembers(OuterClass outer) {
        // compiler error - cannot make a static reference to the non-static field outerClass.outerField
        //System.out.println(OuterClass.outerField);
        System.out.println(outer.outerField);
        System.out.println(OuterClass.staticOuterField);
    }
    
}
