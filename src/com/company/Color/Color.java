package com.company.Color;

public class Color {
    private double red;
    private double green;
    private double blue;

    public Color() {
        this.red = 0;
        this.green = 0;
        this.blue = 0;
    }

    public Color(double red, double green, double blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public double getRed() {
        return red;
    }

    public void setRed(double red) {
        this.red = red;
    }

    public double getGreen() {
        return green;
    }

    public void setGreen(double green) {
        this.green = green;
    }

    public double getBlue() {
        return blue;
    }

    public void setBlue(double blue) {
        this.blue = blue;
    }

    @Override
    public String toString() {
        return "(" + red + "," + green + "," + blue + ")";
    }
}
