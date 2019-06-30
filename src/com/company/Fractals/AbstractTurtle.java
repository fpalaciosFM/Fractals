package com.company.Fractals;

import com.company.Canvas.Canvas;
import com.company.Misc.MyString;
import com.company.PostScript.GraphicsStateOperators.GRestore;
import com.company.PostScript.GraphicsStateOperators.GSave;
import com.company.PostScript.PathConstructionOperators.MoveTo;
import com.company.PostScript.PostScriptInstruction;

import java.util.ArrayList;

public abstract class AbstractTurtle {
    protected double xPos;
    protected double yPos;

    public AbstractTurtle(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
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

    protected abstract void strokeInstruction(ArrayList<PostScriptInstruction> instructions);

    protected abstract void rotateRightInstruction(int i, ArrayList<PostScriptInstruction> instructions);

    protected abstract void rotateLeftInstruction(int i, ArrayList<PostScriptInstruction> instructions);

    protected abstract void forwardInstruction(int i, ArrayList<PostScriptInstruction> instructions);

    protected abstract void forwardLineInstruction(int i, ArrayList<PostScriptInstruction> instructions);

    protected abstract int lineWifthInstruction(String input, int i, ArrayList<PostScriptInstruction> instructions);

    protected abstract int colorInstruction(String input, int i, ArrayList<PostScriptInstruction> instructions);

    protected abstract int stepInstruction(String input, int i);

    protected abstract int directionInstruction(String input, int i, ArrayList<PostScriptInstruction> instructions);

    protected abstract int angleInstruction(String input, int i);
}
