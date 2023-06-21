package com.emlakjet.invoicesystem.util.errors;

import com.emlakjet.invoicesystem.entity.AccountingSpecialist;
import com.emlakjet.invoicesystem.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MissingFieldException.class)
    public ResponseEntity<Response<AccountingSpecialist>> handleMethodArgumentNotValid(MissingFieldException ex) {
        String errorMessage = ex.getExMsg();
        Response<AccountingSpecialist> apiResponse = new Response<>(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), errorMessage, LocalDateTime.now());
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GreaterThenAmountException.class)
    public ResponseEntity<Response<AccountingSpecialist>> handleMethodArgumentNotValid(GreaterThenAmountException ex) {
        String errorMessage = ex.getExMsg();
        Response<AccountingSpecialist> apiResponse = new Response<>(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), errorMessage, LocalDateTime.now());
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccountSpecialistNotFoundException.class)
    public ResponseEntity<Response<AccountingSpecialist>> handleMethodArgumentNotValid(AccountSpecialistNotFoundException ex) {
        String errorMessage = ex.getExMsg();
        Response<AccountingSpecialist> apiResponse = new Response<>(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.value(), errorMessage, LocalDateTime.now());
        return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
    }
}
