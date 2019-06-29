package com.company.Canvas;

import com.company.PostScript.CoordinateSystemOperators.Translate;
import com.company.PostScript.DeviceOperators.SetPageDevice;
import com.company.PostScript.PostScriptInstruction;

import java.util.ArrayList;

public abstract class Canvas {
    private double xPos;
    private double yPos;
    private double xMin;
    private double yMin;
    private double xMax;
    private double yMax;
    private double xScale;
    private double yScale;
    private ArrayList<Canvas> subcanvas;
    private ArrayList<PostScriptInstruction> instructions;

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

    public ArrayList<String> draw() {
        ArrayList<String> strings = new ArrayList<>();
        this.trace(strings);
        for (Canvas canvas : this.subcanvas) {
            canvas.trace(strings);
            updateDimensions(canvas.xMax,canvas.yMax);
            updateDimensions(canvas.xMin,canvas.yMin);
        }
        strings.add(0,(new Translate(-this.xMin,-this.yMin)).performOn(this));
        strings.add(0,(new SetPageDevice(this.xMax-this.xMin,this.yMax-this.yMin)).performOn(this));
        return strings;
    }

    public void updateDimensions(double x, double y){
        if (this.getxMin()>x){
            this.setxMin(x);
        }
        if (this.getxMax()<x){
            this.setxMax(x);
        }
        if (this.getyMin()>y){
            this.setyMin(y);
        }
        if (this.getyMax()<y){
            this.setyMax(y);
        }
    }

    public abstract void trace(ArrayList<String> strings);
}
