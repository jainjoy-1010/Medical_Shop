package org.example.medical_shop.controller;

import org.example.medical_shop.dto.SupplierDTO.SupplierRequestDTO;
import org.example.medical_shop.dto.SupplierDTO.SupplierResponseDTO;
import org.example.medical_shop.models.Supplier;
import org.example.medical_shop.services.SupplierService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/create")
    public SupplierResponseDTO createSupplier(@RequestBody SupplierRequestDTO supplierRequestDTO) {
        Supplier supplier = supplierService.createSupplier(supplierRequestDTO);

        return mapToDto(supplier);
    }

    @GetMapping("/{id}")
    public SupplierResponseDTO getSupplier(@PathVariable Long id) {
        Supplier supplier = supplierService.getSupplierById(id);
        return mapToDto(supplier);
    }

    @GetMapping("/all")
    public List<SupplierResponseDTO> getAllSuppliers() {

         return supplierService.getAllSuppliers()
                 .stream()
                 .map(this::mapToDto)
                 .toList();
    }

    public SupplierResponseDTO mapToDto(Supplier supplier) {
        SupplierResponseDTO supplierResponseDTO = new SupplierResponseDTO();
        supplierResponseDTO.setSupplierName(supplier.getSupplierName());
        supplierResponseDTO.setSupplierId(supplier.getId());

        return supplierResponseDTO;
    }
}
