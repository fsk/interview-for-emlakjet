package com.emlakjet.invoicesystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "invoice")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "bill_no")
    private String billNo;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="specialist_id", nullable=false)
    @JsonBackReference
    private AccountingSpecialist specialist;

}
