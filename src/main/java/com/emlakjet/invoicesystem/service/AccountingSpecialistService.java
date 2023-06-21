package com.emlakjet.invoicesystem.service;

import com.emlakjet.invoicesystem.entity.AccountingSpecialist;
import com.emlakjet.invoicesystem.repository.AccountingSpecialistRepository;
import com.emlakjet.invoicesystem.util.errors.MissingFieldException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountingSpecialistService {

    private final AccountingSpecialistRepository accountingSpecialistRepository;

    public AccountingSpecialist createNewAccountingSpecialist(AccountingSpecialist accountingSpecialist) {
        getValidationAccountSpecialistRequest(accountingSpecialist);
        return accountingSpecialistRepository.save(accountingSpecialist);
    }

    private void getValidationAccountSpecialistRequest(AccountingSpecialist accountingSpecialist) {
        if (Objects.isNull(accountingSpecialist.getFirstName()) || Objects.isNull(accountingSpecialist.getLastName())
        || accountingSpecialist.getEmails().isEmpty()) {
            throw new MissingFieldException();
        }
    }
}
