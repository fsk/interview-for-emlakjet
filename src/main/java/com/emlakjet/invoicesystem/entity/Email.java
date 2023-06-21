package com.emlakjet.invoicesystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "email")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Email {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String emailAddress;

    @ManyToOne
    @JoinColumn(name="specialist_id", nullable=false)
    @JsonBackReference
    private AccountingSpecialist specialist;

}
