package com.matej.learn;

public class TwoDShape {
    private double width;
    private double height;

    TwoDShape() {
        width = height = 0;
    }

    TwoDShape(double w, double h) {
        width = w;
        height = h;
    }

    // accessors for width and height
    double getWidth() { return width; }
    double getHeight() { return height; }
    void setWidth(double w) { width = w; }
    void setHeight(double h) { height = h; }

    void showDim() {
        System.out.println("Width and height are: " + width + " and " + height);
    }
}

class Triangle extends TwoDShape {
    private String style;

    // Constructor
    Triangle(String s, double w, double h) {
        super(w, h);
        
        /* no longer necessary since constructor change 
        setWidth(w);
        setHeight(h);
        */

        style = s;
    }

    double area() {
        return getWidth() * getHeight() / 2;
    }

    void showStyle() {
        System.out.println("Triangle is " + style);
    }
}

class ColorTriangle extends Triangle {
    private String color;

    ColorTriangle(String c, String s, double w, double h) {
        super(s, w, h);
        color = c;
    }

    String getColor() { return color; }
    
}
