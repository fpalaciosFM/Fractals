package com.company;

import com.company.Canvas.Canvas;
import com.company.Canvas.Margin;
import com.company.Canvas.MyCanvas.Rectangle;
import com.company.Canvas.MyCanvas.VerticalGradientRectangle;
import com.company.Color.Color;
import com.company.Color.Gradient;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter buffer = new BufferedWriter(new FileWriter("Prueba.ps"));

        Gradient gradient = new Gradient(
                new Color(0.8, 0, 0.5),
                new Color(0, 0, 0.5),
                new Color(0.5, 0, 0.8)
        );

        Gradient gradient1 = new Gradient(
                new Color(0, 0.6, 0.2),
                new Color(0, 1, 0.5),
                new Color(0, 0.8, 1)
        );

        VerticalGradientRectangle rectangle = new VerticalGradientRectangle(0, 0, 300, 200, gradient, 300);
        VerticalGradientRectangle rectangle1 = new VerticalGradientRectangle(-150, -100, 300, 200, gradient1, 300);

        Rectangle rectangle2 = new Rectangle(
                50,
                50,
                200,
                100,
                new Color(0, 0, 0.5)
        );

        Rectangle rectangle3 = new Rectangle(
                100,
                100,
                200,
                100,
                new Color(0, 0.5, 0.5)
        );

        Canvas canvas = new Canvas() {
            @Override
            public void trace(ArrayList<String> strings) {

            }

            @Override
            public void initSubcanvas() {
                this.getSubcanvas().add(rectangle);
                this.getSubcanvas().add(rectangle1);
            }
        };

        for (String str : canvas.draw(new Margin(15))) {
            System.out.println(str);
            buffer.write(str);
            buffer.newLine();
        }
        buffer.close();
    }
}
