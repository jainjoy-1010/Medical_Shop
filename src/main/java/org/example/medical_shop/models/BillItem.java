package org.example.medical_shop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class BillItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Bill bill;

    @ManyToOne
    private Medicine medicine;

    private int quantity;
    private double price;



}
