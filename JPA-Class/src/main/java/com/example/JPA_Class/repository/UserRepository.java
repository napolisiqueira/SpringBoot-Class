package com.example.JPA_Class.repository;

import com.example.JPA_Class.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
