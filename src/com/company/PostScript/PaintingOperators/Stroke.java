package com.company.PostScript.PaintingOperators;

import com.company.Canvas.Canvas;
import com.company.PostScript.PostScriptInstruction;

public class Stroke extends PostScriptInstruction {
    @Override
    public String performOn(Canvas c) {
        return "stroke";
    }
}
