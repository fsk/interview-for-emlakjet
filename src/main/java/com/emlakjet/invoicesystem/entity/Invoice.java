package com.emlakjet.invoicesystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "invoice")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "bill_no")
    private String billNo;

    @Column(name = "amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name="specialist_id", nullable=false)
    private AccountingSpecialist specialist;

}
