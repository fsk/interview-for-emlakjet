package com.emlakjet.invoicesystem.util.errors;

public class AccountSpecialistNotFoundException extends RuntimeException{

    private static final String EX_MSG = "Account Specialist Not Found.!";

    public String getExMsg() {
        return EX_MSG;
    }

}
