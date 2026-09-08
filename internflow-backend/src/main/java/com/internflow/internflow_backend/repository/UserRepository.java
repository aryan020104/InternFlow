package com.internflow.internflow_backend.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internflow.internflow_backend.entity.Role;
import com.internflow.internflow_backend.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    List<User> findByRole(Role role);

    Optional<User> findByEmail(String email);
}
