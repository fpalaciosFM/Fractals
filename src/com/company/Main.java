package com.company;

import com.company.Canvas.Margin;
import com.company.Fractals.MyTurtles.AbsoluteTurtle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        AbsoluteTurtle absoluteTurtle = new AbsoluteTurtle();

        BufferedWriter buffer = new BufferedWriter(new FileWriter("prueba.ps"));
        for (String str: absoluteTurtle.start("S(10) A(90) F+F-F+F-F- P(1,0,0)$ F+F-F+F-F- P(0,1,0)$ F+F-F+F-F- P(0,0,1)$ F+F-F+F-F- P(0,1,1)$").draw(new Margin(5))){
            System.out.println(str);
            buffer.write(str);
            buffer.newLine();
        }
        buffer.close();
    }
}
