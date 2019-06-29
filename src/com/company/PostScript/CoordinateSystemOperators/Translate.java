package com.company.PostScript.CoordinateSystemOperators;

import com.company.Canvas.Canvas;
import com.company.PostScript.PostScriptInstruction;

public class Translate extends PostScriptInstruction {
    private double tx;
    private double ty;

    public Translate(double tx, double ty) {
        this.tx = tx;
        this.ty = ty;
    }

    @Override
    public String performOn(Canvas c) {
        return tx + " " + ty + " translate";
    }
}
