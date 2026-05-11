package org.example.medical_shop.dto.PurchaseDTO;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class PurchaseResponseDTO {
    private Long id;
    private Long supplierId;
    private double totalAmount;
    private Date date;
    private List<PurchaseItemResponseDTO> purchaseItems;
}
