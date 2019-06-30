package com.company.PostScript.GraphicsStateOperators;

import com.company.Canvas.Canvas;
import com.company.PostScript.PostScriptInstruction;

public class GRestore extends PostScriptInstruction {
    @Override
    public String performOn(Canvas c) {
        return "grestore";
    }
}
