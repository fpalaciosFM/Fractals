package com.company.Fractals;

import com.company.Canvas.Canvas;

import java.util.ArrayList;

public class Turtle {
    private double xPos;
    private double yPos;
    private double angle;
    private double rotation;
    private double step;

    public Turtle(double xPos, double yPos, double angle, double rotation, double step) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.angle = angle;
        this.rotation = rotation;
        this.step = step;
    }

    public Turtle() {
        this(0,0,0,0,0);
    }

    public Canvas start(String input){
        Canvas canvas = new Canvas() {
            @Override
            public void initSubcanvas() {

            }

            @Override
            public void initInstructions() {

            }
        };

        return canvas;
    }
}
