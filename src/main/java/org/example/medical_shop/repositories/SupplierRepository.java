package org.example.medical_shop.repositories;

import org.example.medical_shop.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    Supplier findSupplierById(Long id);
}
