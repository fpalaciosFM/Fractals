package com.company;

import com.company.Canvas.Canvas;
import com.company.Canvas.MyCanvas.VerticalGradientRectangle;
import com.company.Color.Color;
import com.company.Color.Gradient;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter buffer = new BufferedWriter(new FileWriter("Prueba.ps"));

        Gradient gradient = new Gradient(
                new Color(0.8,0,0),
                new Color(0.9,0.9,0.9),
                new Color(0,0,0.8)
        );

        Gradient gradient1 = new Gradient(
                new Color(0,0.5,0.8),
                new Color(0,1,0.5),
                new Color(0,0.8,1)
        );

        VerticalGradientRectangle rectangle = new VerticalGradientRectangle(0,0,300,200,gradient,300);
        VerticalGradientRectangle rectangle1 = new VerticalGradientRectangle(150,100,300,200,gradient1,300);
        Canvas canvas = new Canvas() {
            @Override
            public void trace(ArrayList<String> strings) {
                rectangle.trace(strings);
                rectangle1.trace(strings);
            }
        };
        for (String str:canvas.draw()){
            System.out.println(str);
            buffer.write(str);
            buffer.newLine();
        }
        buffer.close();
    }
}
