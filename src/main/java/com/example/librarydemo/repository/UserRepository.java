package com.example.librarydemo.repository;


import com.example.librarydemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    boolean existsUserByFirstnameAndLastname(String firstname, String lastname);




}
