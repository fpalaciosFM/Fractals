package com.company.Misc.Exceptions;

public class CommaExpectedException extends RuntimeException {
    public CommaExpectedException() {
        super("Se esperaba ','");
    }
}
