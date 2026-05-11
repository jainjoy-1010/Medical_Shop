package org.example.medical_shop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter

public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseItem> purchaseItems;

    private double totalAmount;

    @ManyToOne
    private Supplier supplier;
    private Date date;
}
