package org.example.medical_shop.dto.MedicineDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MedicineResponseDTO {
    private Long id;
    private String medicineName;
    private double quantity;
    private double price;

}
