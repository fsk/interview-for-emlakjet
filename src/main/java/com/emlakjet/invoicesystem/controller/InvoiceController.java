package com.emlakjet.invoicesystem.controller;

import com.emlakjet.invoicesystem.entity.Invoice;
import com.emlakjet.invoicesystem.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping("/")
    public ResponseEntity<Invoice> createNewAccountingSpecialist(@RequestBody Invoice invoice) throws IllegalAccessException {
        return ResponseEntity.ok(invoiceService.createNewInvoice(invoice));
    }


}
