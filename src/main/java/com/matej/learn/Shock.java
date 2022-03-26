package com.matej.learn;

public class Shock {
    public static int bang;
    public static Shock baby;

    public Shock() {
        this.bang = 100;
    }

    public Shock(int num) {
        this.bang = num;
        baby = starter();
        this.bang += num;
    }

    public static Shock starter() {
        Shock gear = new Shock();
        return gear;
    }

    public static void shrink(Shock statik) {
        statik.bang -= 1;
    }

    
}
