package org.example.medical_shop.services;

import org.example.medical_shop.dto.MedicineDTO.MedicineRequestDTO;
import org.example.medical_shop.models.Medicine;
import org.example.medical_shop.repositories.MedicineRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MedicineService {
    private MedicineRepository medicineRepository;
    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    // adding a med
    public Medicine addMedicine(MedicineRequestDTO medicineRequestDTO) {
        Medicine medicine = new Medicine();
        medicine.setName(medicineRequestDTO.getMedicineName());
        medicine.setPrice(medicineRequestDTO.getPrice());
        medicine.setQuantity(medicineRequestDTO.getQuantity());

        return medicineRepository.save(medicine);
    }


    public Medicine getMedicine(Long id){
        return medicineRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Medicine not found"));

    }
}
