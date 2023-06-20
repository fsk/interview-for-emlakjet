package com.emlakjet.invoicesystem.controller;

import com.emlakjet.invoicesystem.entity.AccountingSpecialist;
import com.emlakjet.invoicesystem.service.AccountingSpecialistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/specialist")
@RequiredArgsConstructor
public class AccountingSpecialistController {

    private final AccountingSpecialistService accountingSpecialistService;

    @PostMapping("/")
    public ResponseEntity<AccountingSpecialist> createNewAccountingSpecialist(@RequestBody AccountingSpecialist accountingSpecialist) {
        return ResponseEntity.ok(accountingSpecialistService.createNewAccountingSpecialist(accountingSpecialist));
    }

}
