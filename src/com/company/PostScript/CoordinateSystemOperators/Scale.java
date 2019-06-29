package com.company.PostScript.CoordinateSystemOperators;

import com.company.Canvas.Canvas;
import com.company.PostScript.PostScriptInstruction;

public class Scale extends PostScriptInstruction {
    private double sx;
    private double sy;

    public Scale(double sx, double sy) {
        this.sx = sx;
        this.sy = sy;
    }


    @Override
    public String performOn(Canvas c) {
        return sx + " " + sy + " scale";
    }
}
