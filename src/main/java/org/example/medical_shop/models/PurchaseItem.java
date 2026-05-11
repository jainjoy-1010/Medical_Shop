package org.example.medical_shop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PurchaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double quantity;
    private double price;
    @ManyToOne
    private Purchase purchase;
    @ManyToOne
    private Medicine medicine;
}
