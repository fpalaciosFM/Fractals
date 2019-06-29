package com.company.PostScript.PaintingOperators;

import com.company.Canvas.Canvas;
import com.company.PostScript.PostScriptInstruction;

public class Fill extends PostScriptInstruction {

    @Override
    public String performOn(Canvas c) {
        return "fill";
    }
}
