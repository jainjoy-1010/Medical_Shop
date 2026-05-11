package org.example.medical_shop.dto.PurchaseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseItemResponseDTO {
    private Long medicineId;
    private double quantity;
    private double price;
}
