package com.emlakjet.invoicesystem.controller;

import com.emlakjet.invoicesystem.entity.AccountingSpecialist;
import com.emlakjet.invoicesystem.service.AccountingSpecialistService;
import com.emlakjet.invoicesystem.util.Response;
import com.emlakjet.invoicesystem.util.SuccessMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping(value = "/specialist")
@RequiredArgsConstructor
public class AccountingSpecialistController {

    private final AccountingSpecialistService accountingSpecialistService;

    @PostMapping("/")
    public ResponseEntity<Response<AccountingSpecialist>> createNewAccountingSpecialist(@RequestBody AccountingSpecialist accountingSpecialist) {
        AccountingSpecialist newAccountingSpecialist = accountingSpecialistService.createNewAccountingSpecialist(accountingSpecialist);
        return ResponseEntity.ok(new Response<>(HttpStatus.CREATED,
                                                HttpStatus.CREATED.value(),
                                                SuccessMessages.CREATE_NEW_ACCOUNT_SPECIALIST_SUCCESS_MESSAGE,
                                                newAccountingSpecialist));
    }

}
