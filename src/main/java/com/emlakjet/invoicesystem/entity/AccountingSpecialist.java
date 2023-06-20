package com.emlakjet.invoicesystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "accounting_specialist")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountingSpecialist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Email> emails;

    @OneToMany(mappedBy="specialist")
    private List<Invoice> invoices;

}
