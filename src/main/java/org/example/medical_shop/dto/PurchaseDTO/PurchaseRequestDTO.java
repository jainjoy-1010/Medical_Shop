package org.example.medical_shop.dto.PurchaseDTO;

import lombok.Getter;
import lombok.Setter;
import org.example.medical_shop.models.PurchaseItem;

import java.util.List;

@Getter
@Setter
public class PurchaseRequestDTO {
    private Long supplierId;
    private List<PurchaseItemRequestDTO> purchaseItems;



}
