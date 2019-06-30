package com.company.Canvas.MyCanvas;

import com.company.Canvas.Canvas;
import com.company.Color.Color;
import com.company.PostScript.GraphicsStateOperators.SetRGBColor;
import com.company.PostScript.PaintingOperators.Fill;
import com.company.PostScript.PaintingOperators.Stroke;
import com.company.PostScript.PathConstructionOperators.LineTo;
import com.company.PostScript.PathConstructionOperators.MoveTo;

import java.util.ArrayList;

public class Rectangle extends Canvas {
    private double width;
    private double height;
    private Color color;

    public Rectangle(double xPos, double yPos, double width, double height, Color color) {
        super();
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void trace(ArrayList<String> strings) {
        strings.add((new MoveTo(xPos, yPos)).performOn(this));
        strings.add((new LineTo(xPos + width, yPos)).performOn(this));
        strings.add((new LineTo(xPos + width, yPos + height)).performOn(this));
        strings.add((new LineTo(xPos, yPos + height)).performOn(this));
        strings.add((new LineTo(xPos, yPos)).performOn(this));
        strings.add((new SetRGBColor(color)).performOn(this));
        strings.add((new Stroke()).performOn(this));
        strings.add((new Fill()).performOn(this));
    }

    @Override
    public void initSubcanvas() {

    }
}
