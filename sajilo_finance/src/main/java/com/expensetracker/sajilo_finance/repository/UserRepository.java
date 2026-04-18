package com.expensetracker.sajilo_finance.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.expensetracker.sajilo_finance.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByEmail(String email); // if optional is used then only one email is given if it exist

}
