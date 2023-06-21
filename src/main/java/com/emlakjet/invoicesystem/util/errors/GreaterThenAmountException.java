package com.emlakjet.invoicesystem.util.errors;

public class GreaterThenAmountException extends RuntimeException {

    private static final String EX_MSG = "Provided Amount is greater then from sum of total amount in DB";

    public String getExMsg() {
        return EX_MSG;
    }


}
