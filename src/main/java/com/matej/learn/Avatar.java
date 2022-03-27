package com.matej.learn;

public class Avatar {
    private static String electricity;
    public String fluid;

    public Avatar() {
        
    }

    public Avatar(String str1, String str2) {
        Avatar.electricity = str1;
        this.fluid = str2;
    }

    public static String getElectricity() {
        return electricity;
    }
}