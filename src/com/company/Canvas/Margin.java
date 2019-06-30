package com.company.Canvas;

public class Margin {
    private double topMargin;
    private double bottomMargin;
    private double leftMargin;
    private double rightMargin;

    public Margin(double topMargin, double bottomMargin, double leftMargin, double rightMargin) {
        this.topMargin = topMargin;
        this.bottomMargin = bottomMargin;
        this.leftMargin = leftMargin;
        this.rightMargin = rightMargin;
    }

    public Margin(double verticalMargin, double horizontalMargin) {
        this(verticalMargin, verticalMargin, horizontalMargin, horizontalMargin);
    }

    public Margin(double allMargin) {
        this(allMargin,allMargin);
    }

    public double getTopMargin() {
        return topMargin;
    }

    public void setTopMargin(double topMargin) {
        this.topMargin = topMargin;
    }

    public double getBottomMargin() {
        return bottomMargin;
    }

    public void setBottomMargin(double bottomMargin) {
        this.bottomMargin = bottomMargin;
    }

    public double getLeftMargin() {
        return leftMargin;
    }

    public void setLeftMargin(double leftMargin) {
        this.leftMargin = leftMargin;
    }

    public double getRightMargin() {
        return rightMargin;
    }

    public void setRightMargin(double rightMargin) {
        this.rightMargin = rightMargin;
    }
}
