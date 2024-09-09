package com.example.springtestconcepts.repository;

import com.example.springtestconcepts.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
