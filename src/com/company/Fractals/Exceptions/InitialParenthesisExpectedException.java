package com.company.Fractals.Exceptions;

public class InitialParenthesisExpectedException extends RuntimeException {
    public InitialParenthesisExpectedException() {
        super("Se esperaba '('");
    }
}
