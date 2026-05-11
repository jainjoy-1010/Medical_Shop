package org.example.medical_shop.repositories;

import org.example.medical_shop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
