package org.example.medical_shop.controller;

import org.example.medical_shop.dto.MedicineDTO.MedicineRequestDTO;
import org.example.medical_shop.dto.MedicineDTO.MedicineResponseDTO;
import org.example.medical_shop.models.Medicine;
import org.example.medical_shop.services.MedicineService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicine")
public class MedicineController {

    private MedicineService medicineService;

    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @PostMapping("/add")
    public MedicineResponseDTO addMedicine(@RequestBody MedicineRequestDTO medicineRequestDTO) {

        Medicine medicine = medicineService.addMedicine(medicineRequestDTO);
        return mapToDto(medicine);
    }

    //get a medicine  by ID
    @GetMapping("/{id}")
    public MedicineResponseDTO getMedicineById(@PathVariable Long id) {
        Medicine medicine =medicineService.getMedicine(id);
        return mapToDto(medicine);
    }

    public MedicineResponseDTO mapToDto(Medicine medicine) {

        MedicineResponseDTO medicineResponseDTO = new MedicineResponseDTO();

        medicineResponseDTO.setMedicineName(medicine.getName());
        medicineResponseDTO.setId( medicine.getId());
        medicineResponseDTO.setQuantity(medicine.getQuantity());
        medicineResponseDTO.setPrice(medicine.getPrice());

        return medicineResponseDTO;
    }
}
