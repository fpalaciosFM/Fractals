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
    private double x;
    private double y;
    private double width;
    private double height;
    private Color color;

    public Rectangle(double x, double y, double width, double height, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void trace(ArrayList<String> strings) {
        strings.add((new MoveTo(x, y)).performOn(this));
        strings.add((new LineTo(x + width, y)).performOn(this));
        strings.add((new LineTo(x + width, y + height)).performOn(this));
        strings.add((new LineTo(x, y + height)).performOn(this));
        strings.add((new LineTo(x, y)).performOn(this));
        strings.add((new SetRGBColor(color)).performOn(this));
        strings.add((new Stroke()).performOn(this));
        strings.add((new Fill()).performOn(this));
    }
}
