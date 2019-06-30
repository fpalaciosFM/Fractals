package com.company.Canvas;

import com.company.PostScript.CoordinateSystemOperators.Translate;
import com.company.PostScript.DeviceOperators.SetPageDevice;
import com.company.PostScript.PostScriptInstruction;

import java.util.ArrayList;

public abstract class Canvas {
    protected double xPos;
    protected double yPos;
    private double xMin;
    private double yMin;
    private double xMax;
    private double yMax;
    private double xScale;
    private double yScale;
    private ArrayList<Canvas> subcanvas;
    protected ArrayList<PostScriptInstruction> instructions;

    public Canvas(double xPos, double yPos, double xMin, double yMin, double xMax, double yMax, double xScale, double yScale, ArrayList<Canvas> subcanvas, ArrayList<PostScriptInstruction> instructions) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
        this.xScale = xScale;
        this.yScale = yScale;
        this.subcanvas = subcanvas;
        this.instructions = instructions;
    }

    public Canvas(double xPos, double yPos) {
        this(xPos, yPos, 0, 0, 0, 0, 1, 1, new ArrayList<>(), new ArrayList<>());
    }

    public Canvas() {
        this(0, 0);
    }

    public double getxPos() {
        return xPos;
    }

    public void setxPos(double xPos) {
        this.xPos = xPos;
    }

    public double getyPos() {
        return yPos;
    }

    public void setyPos(double yPos) {
        this.yPos = yPos;
    }

    public double getxMin() {
        return xMin;
    }

    public void setxMin(double xMin) {
        this.xMin = xMin;
    }

    public double getyMin() {
        return yMin;
    }

    public void setyMin(double yMin) {
        this.yMin = yMin;
    }

    public double getxMax() {
        return xMax;
    }

    public void setxMax(double xMax) {
        this.xMax = xMax;
    }

    public double getyMax() {
        return yMax;
    }

    public void setyMax(double yMax) {
        this.yMax = yMax;
    }

    public ArrayList<Canvas> getSubcanvas() {
        return subcanvas;
    }

    public ArrayList<PostScriptInstruction> getInstructions() {
        return instructions;
    }

    public ArrayList<String> draw(Margin margin) {
        ArrayList<String> strings = new ArrayList<>();
        this.trace(strings);
        this.traceSubcanvas(strings);
        strings.add(0, (new Translate(margin.getLeftMargin() - this.xMin, margin.getBottomMargin() - this.yMin)).performOn(this));
        strings.add(0, (
                new SetPageDevice(
                        (margin.getLeftMargin() + margin.getRightMargin()) + (this.xMax - this.xMin),
                        (margin.getBottomMargin() + margin.getTopMargin()) + (this.yMax - this.yMin)
                )).performOn(this)
        );
        return strings;
    }

    public ArrayList<String> draw() {
        return draw(new Margin(0));
    }

    private void traceSubcanvas(ArrayList<String> strings) {
        if (this.subcanvas.size() <= 0) {
            initSubcanvas();
        }
        for (Canvas canvas : this.subcanvas) {
            canvas.traceSubcanvas(strings);
            canvas.trace(strings);
            updateDimensions(canvas.xMax, canvas.yMax);
            updateDimensions(canvas.xMin, canvas.yMin);
        }
    }

    public void trace(ArrayList<String> strings) {
        this.initInstructions();
        for (PostScriptInstruction instruction : this.instructions) {
            strings.add(instruction.performOn(this));
        }
    }

    public abstract void initSubcanvas();
    public abstract void initInstructions();

    public void updateDimensions(double x, double y) {
        this.setxMin(Math.min(xMin, x));
        this.setxMax(Math.max(xMax, x));
        this.setyMin(Math.min(yMin, y));
        this.setyMax(Math.max(yMax, y));
    }

    @Override
    public String toString() {
        return "Canvas{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                ", xMin=" + xMin +
                ", yMin=" + yMin +
                ", xMax=" + xMax +
                ", yMax=" + yMax +
                ", xScale=" + xScale +
                ", yScale=" + yScale +
                ", subcanvas=" + subcanvas +
                ", instructions=" + instructions +
                '}';
    }
}
