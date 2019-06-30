package com.company.PostScript.GraphicsStateOperators;

import com.company.Canvas.Canvas;
import com.company.Color.Color;
import com.company.Misc.MyMath;
import com.company.PostScript.PostScriptInstruction;

public class SetRGBColor extends PostScriptInstruction {
    private Color color;

    public SetRGBColor(Color color) {
        this.color = color;
    }

    @Override
    public String performOn(Canvas c) {
        return MyMath.round(color.getRed()) + " " + MyMath.round(color.getGreen()) + " " + MyMath.round(color.getBlue()) + " setrgbcolor";
    }
}
