package org.example.medical_shop.controller;

import org.example.medical_shop.dto.PurchaseDTO.PurchaseItemResponseDTO;
import org.example.medical_shop.dto.PurchaseDTO.PurchaseRequestDTO;
import org.example.medical_shop.dto.PurchaseDTO.PurchaseResponseDTO;
import org.example.medical_shop.models.Purchase;
import org.example.medical_shop.models.PurchaseItem;
import org.example.medical_shop.services.PurchaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/create")
public class PurchaseController {

    private PurchaseService purchaseService;
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

@PostMapping("/purchase")
    public PurchaseResponseDTO createPurchase(PurchaseRequestDTO purchaseRequestDTO) {
        Purchase  purchase = purchaseService.createPurchase(purchaseRequestDTO);

        return mapToDto(purchase);

    }
    private PurchaseResponseDTO mapToDto(Purchase purchase) {
        PurchaseResponseDTO dto = new PurchaseResponseDTO();

        dto.setId(purchase.getId());
        dto.setTotalAmount(purchase.getTotalAmount());
        dto.setDate(purchase.getDate());
        dto.setSupplierId(purchase.getSupplier().getId());

        List<PurchaseItemResponseDTO> items = new ArrayList<>();

        for (PurchaseItem item : purchase.getPurchaseItems()) {
            PurchaseItemResponseDTO itemDto = new PurchaseItemResponseDTO();

            itemDto.setMedicineId(item.getMedicine().getId());
            itemDto.setPrice(item.getPrice());
            itemDto.setQuantity(item.getQuantity());

            items.add(itemDto);
        }
        dto.setPurchaseItems(items);
        return dto;
    }
}
