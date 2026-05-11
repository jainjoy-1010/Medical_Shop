package org.example.medical_shop.services;

import org.example.medical_shop.dto.SupplierDTO.SupplierRequestDTO;
import org.example.medical_shop.models.Supplier;
import org.example.medical_shop.repositories.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public Supplier createSupplier(SupplierRequestDTO supplierRequestDTO) {
        Supplier supplier = new Supplier();
        supplier.setSupplierName(supplierRequestDTO.getName());
        return supplierRepository.save(supplier);
    }


    public Supplier getSupplierById(Long supplierId) {
        Supplier supplier = supplierRepository.findById(supplierId)
                .orElseThrow(()->new RuntimeException("Supplier not found!"));
        return supplier;
    }


    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }
}
