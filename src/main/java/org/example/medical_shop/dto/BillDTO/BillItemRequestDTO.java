package org.example.medical_shop.dto.BillDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillItemRequestDTO {
    private long medicineId;
    private int quantity;
}