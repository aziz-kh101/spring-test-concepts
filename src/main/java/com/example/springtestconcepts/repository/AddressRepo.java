package com.example.springtestconcepts.repository;

import com.example.springtestconcepts.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
