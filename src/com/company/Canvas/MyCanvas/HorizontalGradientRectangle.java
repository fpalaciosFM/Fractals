package com.company.Canvas.MyCanvas;

import com.company.Canvas.Canvas;
import com.company.Color.Gradient;
import com.company.Misc.MyMath;

import java.util.ArrayList;

public class HorizontalGradientRectangle extends Canvas {
    private double width;
    private double height;
    private Gradient gradient;
    private int iterations;

    public HorizontalGradientRectangle(double xPos, double yPos, double width, double height, Gradient gradient, int iterations) {
        super(xPos, yPos);
        this.width = width;
        this.height = height;
        this.gradient = gradient;
        this.iterations = iterations;
    }

    public HorizontalGradientRectangle(double xPos, double yPos, double width, double height, Gradient gradient) {
        this(xPos, yPos, width, height, gradient, (int) MyMath.round(width / 4, 0));
    }

    @Override
    public void trace(ArrayList<String> strings) {
    }

    @Override
    public void initSubcanvas() {
        for (int i = 0; i < iterations - 1; i++) {
            this.getSubcanvas().add(
                    new Rectangle(
                            xPos + i * width / (double) (iterations),
                            yPos,
                            2 * width / (double) (iterations),
                            height,
                            gradient.getAt((double) i / (double) (iterations))
                    )
            );
        }

        this.getSubcanvas().add(
                new Rectangle(
                        xPos + (iterations - 1) * width / (double) (iterations),
                        yPos,
                        width / (double) (iterations),
                        height,
                        gradient.getAt((double) (iterations - 1) / (double) (iterations))
                )
        );
    }

    @Override
    public void initInstructions() {

    }
}
