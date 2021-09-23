package com.project3.ecommerce.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "InvoiceDetails")
public class InvoiceDetails {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_details_id", nullable = false)
    private Long Id;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Double subTotal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id", unique = true)
    private Invoice invoice;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", unique = true)
    private Product product;
}
