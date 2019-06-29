package com.company.PostScript.PathConstructionOperators;

import com.company.Canvas.Canvas;
import com.company.PostScript.PostScriptInstruction;

public class LineTo extends PostScriptInstruction {
    private double x;
    private double y;

    public LineTo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String performOn(Canvas c) {
        c.updateDimensions(x,y);
        return x + " " + y + " lineto";
    }
}
