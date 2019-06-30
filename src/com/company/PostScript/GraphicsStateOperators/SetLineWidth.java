package com.company.PostScript.GraphicsStateOperators;

import com.company.Canvas.Canvas;
import com.company.Misc.MyMath;
import com.company.PostScript.PostScriptInstruction;

public class SetLineWidth extends PostScriptInstruction {
    private double width;

    public SetLineWidth(double width) {
        this.width = width;
    }

    @Override
    public String performOn(Canvas c) {
        return MyMath.round(width) + " setlinewidth";
    }
}
