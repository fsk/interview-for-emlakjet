package com.emlakjet.invoicesystem.repository;

import com.emlakjet.invoicesystem.entity.AccountingSpecialist;
import com.emlakjet.invoicesystem.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountingSpecialistRepository extends JpaRepository<AccountingSpecialist, Long> {

    Optional<AccountingSpecialist> findByFirstNameAndLastName(String firstName, String lastName);

}
