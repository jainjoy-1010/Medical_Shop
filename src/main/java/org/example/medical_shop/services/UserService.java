package org.example.medical_shop.services;

import org.example.medical_shop.dto.UserDTO.UserRequestDTO;
import org.example.medical_shop.models.User;
import org.example.medical_shop.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setUserName(userRequestDTO.getName());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public User getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found!"));

        return user;
    }


}
