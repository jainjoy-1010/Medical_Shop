package org.example.medical_shop.services;

import org.example.medical_shop.dto.PurchaseDTO.PurchaseItemRequestDTO;
import org.example.medical_shop.dto.PurchaseDTO.PurchaseRequestDTO;
import org.example.medical_shop.models.Medicine;
import org.example.medical_shop.models.Purchase;
import org.example.medical_shop.models.PurchaseItem;
import org.example.medical_shop.models.Supplier;
import org.example.medical_shop.repositories.MedicineRepository;
import org.example.medical_shop.repositories.PurchaseRepository;
import org.example.medical_shop.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseService {

    private PurchaseRepository purchaseRepository;
    private MedicineRepository medicineRepository;
    private SupplierRepository supplierRepository;


    public PurchaseService(PurchaseRepository purchaseRepository,
                           MedicineRepository medicineRepository,
                           SupplierRepository supplierRepository) {
        this.purchaseRepository = purchaseRepository;
        this.medicineRepository = medicineRepository;
        this.supplierRepository = supplierRepository;
    }

    public Purchase createPurchase(PurchaseRequestDTO purchaseRequestDTO) {

        Supplier supplier = supplierRepository.findById(purchaseRequestDTO.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        Purchase purchase = new Purchase();
        purchase.setSupplier(supplier);
        purchase.setDate(new Date());

        List<PurchaseItem>  purchaseItems = new ArrayList<>();
        double total = 0;

        for (PurchaseItemRequestDTO purchaseItemRequestDTO :purchaseRequestDTO.getPurchaseItems()) {

            Medicine medicine = medicineRepository.findById(purchaseItemRequestDTO.getMedicineId())
                    .orElseThrow(() -> new RuntimeException("Medicine not found"));


            //stock increase
            medicine.setQuantity(medicine.getQuantity()+purchaseItemRequestDTO.getQuantity());

            PurchaseItem purchaseItem = new PurchaseItem();
            purchaseItem.setMedicine(medicine);
            purchaseItem.setPurchase(purchase);
            purchaseItem.setQuantity(purchaseItemRequestDTO.getQuantity());
            purchaseItem.setPrice(purchaseItemRequestDTO.getPrice());


            purchaseItems.add(purchaseItem);
            total += purchaseItemRequestDTO.getPrice() *purchaseItemRequestDTO.getQuantity();

        }

        purchase.setPurchaseItems(purchaseItems);
        purchase.setTotalAmount(total);

        return purchaseRepository.save(purchase);
    }
}
