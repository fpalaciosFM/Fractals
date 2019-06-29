package com.company;

import com.company.Canvas.MyCanvas.VerticalGradientRectangle;
import com.company.Color.Color;
import com.company.Color.Gradient;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter buffer = new BufferedWriter(new FileWriter("Prueba.ps"));

        Gradient gradient = new Gradient(
                new Color(0,0,0),
                new Color(1,1,1)
        );

        VerticalGradientRectangle rectangle = new VerticalGradientRectangle(0,0,300,200,gradient,300);
        for (String str:rectangle.draw()){
            System.out.println(str);
            buffer.write(str);
            buffer.newLine();
        }
        buffer.close();
    }
}
