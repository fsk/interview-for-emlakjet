package com.emlakjet.invoicesystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "email")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String emailAddress;

    @ManyToOne
    @JoinColumn(name="specialist_id", nullable=false)
    private AccountingSpecialist specialist;

}
