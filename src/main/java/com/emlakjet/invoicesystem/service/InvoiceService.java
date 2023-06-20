package com.emlakjet.invoicesystem.service;

import com.emlakjet.invoicesystem.entity.AccountingSpecialist;
import com.emlakjet.invoicesystem.entity.Invoice;
import com.emlakjet.invoicesystem.repository.AccountingSpecialistRepository;
import com.emlakjet.invoicesystem.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final AccountingSpecialistRepository accountingSpecialistRepository;

    private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    @Value("${emlakjet.amount.value}")
    private Integer amount;


    public Invoice createNewInvoice(Invoice invoice) throws IllegalAccessException {
        if (Objects.isNull(invoice.getSpecialist().getEmails()) || Objects.isNull(invoice.getSpecialist().getFirstName()) ||
        Objects.isNull(invoice.getSpecialist().getLastName())) {
            throw new IllegalAccessException("Missing fields.");
        }

        Optional<AccountingSpecialist> accountingSpecialist = accountingSpecialistRepository
                .findByFirstNameAndLastName(invoice.getSpecialist().getFirstName(), invoice.getSpecialist().getLastName());

        if (!accountingSpecialist.isPresent()) {
            throw new IllegalAccessException("Accounting Specialist Not Found.!");
        }

        int amountValue = accountingSpecialist.get().getInvoices().stream().mapToInt(Invoice::getAmount).sum();

        logger.info("AmountValue from DB : {} ", amountValue);


        if (amountValue > this.amount) {
            throw new IllegalAccessException("Amount is should be less than total amount in Database");
        }

        Invoice savedInvoice = Invoice
                .builder()
                .productName(invoice.getProductName())
                .billNo(invoice.getBillNo())
                .amount(invoice.getAmount())
                .specialist(accountingSpecialist.get())
                .build();

        return invoiceRepository.save(savedInvoice);
    }
}
