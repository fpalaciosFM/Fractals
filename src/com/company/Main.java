package com.company;

import com.company.Canvas.Canvas;
import com.company.Canvas.Margin;
import com.company.Canvas.MyCanvas.Rectangle;
import com.company.Canvas.MyCanvas.HorizontalGradientRectangle;
import com.company.Color.Color;
import com.company.Color.Gradient;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter buffer = new BufferedWriter(new FileWriter("Prueba.ps"));

        Gradient gradient = new Gradient(
                new Color(0.8, 0, 0.5),
                new Color(0, 0, 0.5),
                new Color(0.5, 0, 0.8)
        );

        Gradient gradient1 = new Gradient(
                new Color(0.8, 0.6, 0.2),
                new Color(0.6, 0, 0),
                new Color(0.8, 0.2, 0.6)
        );

        Rectangle rectangle = new Rectangle(150, 100, 150, 100, new Color(0, 0.5, 0.7));
        HorizontalGradientRectangle rectangle1 = new HorizontalGradientRectangle(0,0,300,200,gradient,10);
        HorizontalGradientRectangle rectangle2 = new HorizontalGradientRectangle(150,100,300,200,gradient1,100);

        Canvas canvas = new Canvas() {
            @Override
            public void initSubcanvas() {
                this.getSubcanvas().add(rectangle1);
                this.getSubcanvas().add(rectangle2);
                this.getSubcanvas().add(rectangle);
            }

            @Override
            public void initInstructions() {

            }
        };

        for (String str : canvas.draw(new Margin(5))) {
            System.out.println(str);
            buffer.write(str);
            buffer.newLine();
        }
        buffer.close();
    }
}
