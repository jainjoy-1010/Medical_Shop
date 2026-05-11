package org.example.medical_shop.services;

import org.example.medical_shop.dto.BillDTO.BillItemRequestDTO;
import org.example.medical_shop.dto.BillDTO.BillRequestDTO;
import org.example.medical_shop.models.Bill;
import org.example.medical_shop.models.BillItem;
import org.example.medical_shop.models.Medicine;
import org.example.medical_shop.models.User;
import org.example.medical_shop.repositories.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BillService {

    private BillRepository billRepository;
    private UserRepository userRepository;
    private MedicineRepository medicineRepository;
    private SupplierRepository supplierRepository;
    private PurchaseRepository purchaseRepository;

    public BillService(BillRepository billRepository,
                       UserRepository userRepository,
                       MedicineRepository medicineRepository,
                       SupplierRepository supplierRepository,
                       PurchaseRepository purchaseRepository) {
        this.billRepository = billRepository;
        this.userRepository = userRepository;
        this.medicineRepository = medicineRepository;
        this.supplierRepository = supplierRepository;
        this.purchaseRepository = purchaseRepository;

    }

    public Bill createBill(BillRequestDTO requestDTO) {

        Bill bill = new Bill();
        bill.setDate(new Date());

        User user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(()->new RuntimeException("User not found"));

        bill.setUser(user);

        List< BillItem> billItems = new ArrayList<>();
        double total = 0;

        for (BillItemRequestDTO item : requestDTO.getItems()) {

            Medicine  medicine = medicineRepository.findById(item.getMedicineId())
                    .orElseThrow(()->new RuntimeException("Medicine not found"));

            if(medicine.getQuantity() < item.getQuantity()) {
                throw new RuntimeException("Medicine quantity less than item quantity" + medicine.getName());
            }

            medicine.setQuantity(medicine.getQuantity() - item.getQuantity());

            medicineRepository.save(medicine);

            BillItem billItem = new BillItem();
            billItem.setMedicine(medicine);
            billItem.setQuantity(item.getQuantity());

            double price = medicine.getPrice() * item.getQuantity();
            billItem.setPrice(price);

            total = total + price;

            billItem.setBill(bill);

            billItems.add(billItem);
        }
        bill.setBillItems(billItems);
        bill.setAmount(total);
        billRepository.save(bill);
        return bill;
    }
}
