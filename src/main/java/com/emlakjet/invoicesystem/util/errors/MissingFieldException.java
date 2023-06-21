package com.emlakjet.invoicesystem.util.errors;

public class MissingFieldException extends RuntimeException{
    private static final String EX_MSG = "Missing field.!";

    public String getExMsg() {
        return EX_MSG;
    }
}
