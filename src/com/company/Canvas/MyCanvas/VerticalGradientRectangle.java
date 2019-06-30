package com.company.Canvas.MyCanvas;

import com.company.Canvas.Canvas;
import com.company.Color.Gradient;

import java.util.ArrayList;

public class VerticalGradientRectangle extends Canvas {
    private double width;
    private double height;
    private Gradient gradient;
    private int iterations;

    public VerticalGradientRectangle(double xPos, double yPos, double width, double height, Gradient gradient, int iterations) {
        super(xPos, yPos);
        this.width = width;
        this.height = height;
        this.gradient = gradient;
        this.iterations = iterations;
    }

    @Override
    public void trace(ArrayList<String> strings) {
    }

    @Override
    public void initSubcanvas() {
        for (int i = 0; i < iterations; i++) {
            this.getSubcanvas().add(
                    new Rectangle(
                            xPos + i * width / (double) (iterations - 1),
                            yPos,
                            width / (double) (iterations - 1),
                            height,
                            gradient.getAt((double) i / (double) (iterations - 1))
                    )
            );
        }
    }
}
