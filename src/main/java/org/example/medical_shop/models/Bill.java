package org.example.medical_shop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter

public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "bill")
    private List<BillItem> billItems;

    private double amount;
    private Date date;
    @ManyToOne
    private User user;
    private double total;

}
