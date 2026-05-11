package org.example.medical_shop.dto.MedicineDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MedicineRequestDTO {
    private String medicineName;
    private int quantity;
    private double price;
}
