package com.example.springtestconcepts.service;

import com.example.springtestconcepts.dto.UserRequest;
import com.example.springtestconcepts.dto.UserResponse;
import com.example.springtestconcepts.model.Address;
import com.example.springtestconcepts.model.User;
import com.example.springtestconcepts.repository.AddressRepo;
import com.example.springtestconcepts.repository.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final AddressRepo addressRepo;

//    @Transactional
    public UserResponse addUser(UserRequest userRequest) {
        User user = User.builder()
                .lastName(userRequest.getLastName())
                .firstName(userRequest.getFirstName())
                .age(userRequest.getAge())
                .email(userRequest.getEmail())
                .build();
        Address address = Address.builder()
                .code("123")
                .street("haye khaled ben walid")
                .build();

        user = userRepo.save(user);
        address = addressRepo.save(address);
        user.setAddress(address);
        user = userRepo.save(user);
        return toUserResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        return userRepo.findAll().stream().map(this::toUserResponse).toList();
    }

    private UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .age(user.getAge())
                .address(user.getAddress())
                .build();
    }
}
