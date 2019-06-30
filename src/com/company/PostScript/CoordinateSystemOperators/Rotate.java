package com.company.PostScript.CoordinateSystemOperators;

import com.company.Canvas.Canvas;
import com.company.Misc.MyMath;
import com.company.PostScript.PostScriptInstruction;

public class Rotate extends PostScriptInstruction {
    private double angle;

    public Rotate(double angle) {
        this.angle = angle;
    }

    @Override
    public String performOn(Canvas c) {
        return MyMath.round(angle) + " rotate";
    }
}
