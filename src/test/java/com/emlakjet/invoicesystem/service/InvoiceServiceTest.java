package com.emlakjet.invoicesystem.service;

import com.emlakjet.invoicesystem.entity.AccountingSpecialist;
import com.emlakjet.invoicesystem.entity.Email;
import com.emlakjet.invoicesystem.entity.Invoice;
import com.emlakjet.invoicesystem.repository.AccountingSpecialistRepository;
import com.emlakjet.invoicesystem.repository.InvoiceRepository;
import com.emlakjet.invoicesystem.util.errors.GreaterThenAmountException;
import com.emlakjet.invoicesystem.util.errors.MissingFieldException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceTest {

    @InjectMocks
    private InvoiceService invoiceService;
    @Mock
    private InvoiceRepository invoiceRepository;
    @Mock
    private AccountingSpecialistRepository accountingSpecialistRepository;

    private int amount;
    private AccountingSpecialist accountingSpecialist;
    private Email email;
    private Invoice invoice;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        amount = 200;
        Field field = invoiceService.getClass().getDeclaredField("amount");
        field.setAccessible(true);
        field.set(invoiceService, amount);

        accountingSpecialist = AccountingSpecialist
                .builder()
                .id(1L)
                .firstName("Name")
                .lastName("Surname")
                .build();

        email = Email
                .builder()
                .id(1L)
                .emailAddress("mail@mail.com")
                .specialist(accountingSpecialist)
                .build();

        invoice = Invoice
                .builder()
                .id(1L)
                .billNo("BillNo")
                .productName("ProductName")
                .amount(50)
                .specialist(accountingSpecialist)
                .build();

        List<Email> emailList = List.of(email);
        List<Invoice> invoiceList = List.of(invoice);

        accountingSpecialist.setEmails(emailList);
        accountingSpecialist.setInvoices(invoiceList);
    }

    @Test
    void testGreaterThenAmountException() {
        invoice.setAmount(300);

        when(accountingSpecialistRepository.findByFirstNameAndLastName(accountingSpecialist.getFirstName(),
                accountingSpecialist.getLastName()))
                .thenReturn(Optional.of(accountingSpecialist));

        assertThrows(GreaterThenAmountException.class, () -> invoiceService.createNewInvoice(invoice));
    }

    @Test
    void testMissingFieldException() {
        Invoice invoice = new Invoice();
        AccountingSpecialist accountingSpecialist = new AccountingSpecialist();
        invoice.setSpecialist(accountingSpecialist);
        assertThrows(MissingFieldException.class, () -> invoiceService.createNewInvoice(invoice));
    }

    @Test
    void testCreateNewInvoice() {
        when(accountingSpecialistRepository.findByFirstNameAndLastName(accountingSpecialist.getFirstName(),
                accountingSpecialist.getLastName()))
                .thenReturn(Optional.of(accountingSpecialist));
        when(invoiceRepository.save(any(Invoice.class))).thenReturn(invoice);
        Invoice result = invoiceService.createNewInvoice(invoice);
        assertEquals(invoice, result);
    }
}