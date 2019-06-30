package com.company.Fractals.Exceptions;

public class EndingParenthesisExpectedException extends RuntimeException {
    public EndingParenthesisExpectedException() {
        super("Se esperaba ')'");
    }
}
