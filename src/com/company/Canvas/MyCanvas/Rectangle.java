package com.company.Canvas.MyCanvas;

import com.company.Canvas.Canvas;
import com.company.Color.Color;
import com.company.PostScript.GraphicsStateOperators.SetRGBColor;
import com.company.PostScript.PaintingOperators.Fill;
import com.company.PostScript.PathConstructionOperators.LineTo;
import com.company.PostScript.PathConstructionOperators.MoveTo;

public class Rectangle extends Canvas {
    private double width;
    private double height;
    private Color background;

    public Rectangle(double xPos, double yPos, double width, double height, Color background) {
        super();
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.background = background;
    }

    @Override
    public void initSubcanvas() {

    }

    @Override
    public void initInstructions() {
        instructions.add(new MoveTo(this.xPos, this.yPos));
        instructions.add(new LineTo(this.xPos + this.width, this.yPos));
        instructions.add(new LineTo(this.xPos + this.width, this.yPos + this.height));
        instructions.add(new LineTo(this.xPos, this.yPos + this.height));
        instructions.add(new LineTo(this.xPos, this.yPos));
        instructions.add(new SetRGBColor(this.background));
        instructions.add(new Fill());
    }
}
