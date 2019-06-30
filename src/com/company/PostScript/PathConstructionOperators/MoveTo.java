package com.company.PostScript.PathConstructionOperators;

import com.company.Canvas.Canvas;
import com.company.Misc.MyMath;
import com.company.PostScript.PostScriptInstruction;

public class MoveTo extends PostScriptInstruction {
    private double x;
    private double y;

    public MoveTo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String performOn(Canvas c) {
        c.updateDimensions(x, y);
        return MyMath.round(x) + " " + MyMath.round(y) + " moveto";
    }
}
