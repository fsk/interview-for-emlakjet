package com.emlakjet.invoicesystem.service;

import com.emlakjet.invoicesystem.entity.AccountingSpecialist;
import com.emlakjet.invoicesystem.repository.AccountingSpecialistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountingSpecialistService {

    private final AccountingSpecialistRepository accountingSpecialistRepository;

    public AccountingSpecialist createNewAccountingSpecialist(AccountingSpecialist accountingSpecialist) {
        return accountingSpecialistRepository.save(accountingSpecialist);
    }
}
