package com.emlakjet.invoicesystem.repository;

import com.emlakjet.invoicesystem.entity.AccountingSpecialist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingSpecialistRepository extends JpaRepository<AccountingSpecialist, Long> {
}
