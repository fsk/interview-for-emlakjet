package com.emlakjet.invoicesystem.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    private HttpStatus httpStatus;
    private Integer statusCode;
    private String message;
    private LocalDateTime localDateTime;
    private T data;


    public Response(HttpStatus httpStatus, Integer statusCode, String message, T data) {
        this.httpStatus = httpStatus;
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public Response(HttpStatus httpStatus, Integer statusCode, String message, LocalDateTime localDateTime) {
        this.httpStatus = httpStatus;
        this.statusCode = statusCode;
        this.message = message;
        this.localDateTime = localDateTime;
    }

}

