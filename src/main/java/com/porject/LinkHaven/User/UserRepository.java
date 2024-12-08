package com.porject.LinkHaven.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Customer, Long> {

    public Optional<Customer> findByUsername(String username);
}
