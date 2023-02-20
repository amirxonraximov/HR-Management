package com.example.hrmanagment.repository;

import com.example.hrmanagment.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    boolean existsByEmail(@NotNull @Email String email);

    Optional<Employee> findByEmail(String email);


}
