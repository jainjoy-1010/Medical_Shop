package org.example.medical_shop.dto.PurchaseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PurchaseItemRequestDTO {
    private Long medicineId;
    private double quantity;
    private double price;


}
