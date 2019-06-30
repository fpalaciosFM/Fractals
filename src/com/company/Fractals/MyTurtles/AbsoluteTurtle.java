package com.company.Fractals.MyTurtles;

import com.company.Canvas.Canvas;
import com.company.Color.Color;
import com.company.Fractals.Exceptions.EndingParenthesisExpectedException;
import com.company.Fractals.Exceptions.InitialParenthesisExpectedException;
import com.company.Misc.MyMath;
import com.company.Misc.MyString;
import com.company.PostScript.CoordinateSystemOperators.Rotate;
import com.company.PostScript.GraphicsStateOperators.GRestore;
import com.company.PostScript.GraphicsStateOperators.GSave;
import com.company.PostScript.GraphicsStateOperators.SetLineWidth;
import com.company.PostScript.GraphicsStateOperators.SetRGBColor;
import com.company.PostScript.PaintingOperators.Stroke;
import com.company.PostScript.PathConstructionOperators.LineTo;
import com.company.PostScript.PathConstructionOperators.MoveTo;
import com.company.PostScript.PostScriptInstruction;

import java.util.ArrayList;

public class AbsoluteTurtle {
    private double xPos;
    private double yPos;
    private double angle;
    private double direction;
    private double step;
    private Color color;

    public AbsoluteTurtle(double xPos, double yPos, double angle, double direction, double step) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.angle = angle;
        this.direction = direction;
        this.step = step;
    }

    public AbsoluteTurtle() {
        this(0, 0, 0, 0, 0);
    }

    public Canvas start(String input) {
        Canvas canvas = new Canvas(this.xPos, this.yPos) {
            @Override
            public void initSubcanvas() {

            }

            @Override
            public void initInstructions() {
                this.getInstructions().add(new GSave());
                this.getInstructions().add(new MoveTo(0,0));
                translateInstructions(input, this.getInstructions());
                this.getInstructions().add(new GRestore());
            }
        };

        return canvas;
    }

    private void translateInstructions(String input, ArrayList<PostScriptInstruction> instructions) {
        int i = 0;
        while (i < input.length()) {
            i = MyString.cleanSpaces(input, i);
            switch (input.charAt(i)) {
                case 'A':
                    i = this.angleInstruction(input, i);
                    break;
                case 'D':
                    i = this.directionInstruction(input, i, instructions);
                    break;
                case 'S':
                    i = this.stepInstruction(input, i);
                    break;
                case 'P':
                    i = this.colorInstruction(input, i, instructions);
                    break;
                case 'W':
                    i = this.lineWifthInstruction(input, i, instructions);
                    break;
                case 'F':
                    this.forwardLineInstruction(i, instructions);
                    break;
                case 'f':
                    this.forwardInstruction(i, instructions);
                    break;
                case '+':
                    this.rotateLeftInstruction(i, instructions);
                    break;
                case '-':
                    this.rotateRightInstruction(i, instructions);
                    break;
                case '[':
                    break;
                case ']':
                    break;
                case '$':
                    this.strokeInstruction(instructions);
                    break;
                default:
                    return;
            }


            i++;
        }
    }

    private void strokeInstruction(ArrayList<PostScriptInstruction> instructions) {
        instructions.add(new Stroke());
        instructions.add(new MoveTo(xPos,yPos));
    }

    private void rotateRightInstruction(int i, ArrayList<PostScriptInstruction> instructions) {
        this.direction -= MyMath.round(angle);
//        instructions.add(new Rotate(-angle));
    }

    private void rotateLeftInstruction(int i, ArrayList<PostScriptInstruction> instructions) {
        this.direction += MyMath.round(angle);
//        instructions.add(new Rotate(angle));
    }

    private void forwardInstruction(int i, ArrayList<PostScriptInstruction> instructions) {
        this.xPos += step * Math.cos(Math.toRadians(direction));
        this.yPos += step * Math.sin(Math.toRadians(direction));
        instructions.add(new MoveTo(xPos, yPos));
    }

    private void forwardLineInstruction(int i, ArrayList<PostScriptInstruction> instructions) {
        this.xPos += step * Math.cos(Math.toRadians(direction));
        this.yPos += step * Math.sin(Math.toRadians(direction));
        instructions.add(new LineTo(xPos, yPos));
    }

    private int lineWifthInstruction(String input, int i, ArrayList<PostScriptInstruction> instructions) {
        i = MyString.cleanSpaces(input, i + 1);
        if (input.charAt(i) == '(') {
            i = MyString.cleanSpaces(input, i + 1);

            double newLineWidth = MyString.nextDoubleString(input, i);
            instructions.add(new SetLineWidth(newLineWidth));
            this.direction = newLineWidth;

            i = MyString.nextDoubleIndex(input, i);
            i = MyString.cleanSpaces(input, i);

            if (input.charAt(i) == ')') {
                return i;
            }

            throw new EndingParenthesisExpectedException();
        }

        throw new InitialParenthesisExpectedException();
    }

    private int colorInstruction(String input, int i, ArrayList<PostScriptInstruction> instructions) {
        i = MyString.cleanSpaces(input, i + 1);
        if (input.charAt(i) == '(') {
            double r, g, b;

            i = MyString.cleanSpaces(input, i + 1);
            r = MyString.nextDoubleString(input, i);
            i = MyString.nextDoubleIndex(input, i);

            i = MyString.cleanCommaAndSpaces(input, i);
            g = MyString.nextDoubleString(input, i);
            i = MyString.nextDoubleIndex(input, i);

            i = MyString.cleanCommaAndSpaces(input, i);
            b = MyString.nextDoubleString(input, i);
            i = MyString.nextDoubleIndex(input, i);
            i = MyString.cleanSpaces(input, i);

            if (input.charAt(i) == ')') {
                this.color = new Color(r, g, b);
                instructions.add(new SetRGBColor(this.color));
                return i;
            }

            throw new EndingParenthesisExpectedException();
        }

        throw new InitialParenthesisExpectedException();
    }

    private int directionInstruction(String input, int i, ArrayList<PostScriptInstruction> instructions) {
        i = MyString.cleanSpaces(input, i + 1);
        if (input.charAt(i) == '(') {
            i = MyString.cleanSpaces(input, i + 1);

            double newDirection = MyString.nextDoubleString(input, i);
            instructions.add(new Rotate(newDirection - this.direction));
            this.direction = newDirection;

            i = MyString.nextDoubleIndex(input, i);
            i = MyString.cleanSpaces(input, i);

            if (input.charAt(i) == ')') {
                return i;
            }

            throw new EndingParenthesisExpectedException();
        }

        throw new InitialParenthesisExpectedException();
    }

    private int angleInstruction(String input, int i) {
        i = MyString.cleanSpaces(input, i + 1);
        if (input.charAt(i) == '(') {
            i = MyString.cleanSpaces(input, i + 1);
            this.angle = MyString.nextDoubleString(input, i);
            i = MyString.nextDoubleIndex(input, i);
            i = MyString.cleanSpaces(input, i);

            if (input.charAt(i) == ')') {
                return i;
            }

            throw new EndingParenthesisExpectedException();
        }

        throw new InitialParenthesisExpectedException();
    }

    private int stepInstruction(String input, int i) {
        i = MyString.cleanSpaces(input, i + 1);
        if (input.charAt(i) == '(') {
            i = MyString.cleanSpaces(input, i + 1);
            this.step = MyString.nextDoubleString(input, i);
            i = MyString.nextDoubleIndex(input, i);
            i = MyString.cleanSpaces(input, i);

            if (input.charAt(i) == ')') {
                return i;
            }

            throw new EndingParenthesisExpectedException();
        }

        throw new InitialParenthesisExpectedException();
    }
}
