package org.example.medical_shop.controller;

import org.example.medical_shop.dto.UserDTO.UserRequestDTO;
import org.example.medical_shop.dto.UserDTO.UserResponseDTO;
import org.example.medical_shop.models.User;
import org.example.medical_shop.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO) {
        User user = userService.createUser(userRequestDTO);
        return mapToDto(user);
    }

    @GetMapping("/{userId}")
    public UserResponseDTO getUser(@PathVariable Long userId) {
        User user = userService.getUser(userId);
        return mapToDto(user);
    }

    @GetMapping("/all")
    public List<UserResponseDTO> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    private UserResponseDTO mapToDto(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserId(user.getUserId());
        userResponseDTO.setName(user.getUserName());

        return userResponseDTO;
    }


}
