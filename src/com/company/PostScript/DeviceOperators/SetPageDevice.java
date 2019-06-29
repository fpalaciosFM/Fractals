package com.company.PostScript.DeviceOperators;

import com.company.Canvas.Canvas;
import com.company.PostScript.PostScriptInstruction;

public class SetPageDevice extends PostScriptInstruction {
    private double paperWidth;
    private double paperHeight;

    public SetPageDevice(double paperWidth, double paperHeight) {
        this.paperWidth = paperWidth;
        this.paperHeight = paperHeight;
    }

    @Override
    public String performOn(Canvas c) {
        return "<< /PageSize [" + paperWidth + " " + paperHeight + "] >> setpagedevice";
    }
}
