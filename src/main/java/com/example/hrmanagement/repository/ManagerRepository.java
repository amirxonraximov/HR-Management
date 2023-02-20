package com.example.hrmanagment.repository;

import com.example.hrmanagment.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

public interface ManagerRepository extends JpaRepository<Manager, UUID> {

    boolean existsByEmail(@NotNull @Email String email);

    Optional<Manager> findByEmailAndEmailCode(String email, String emailCode);

    Optional<Manager> findByEmail(String email);
}
