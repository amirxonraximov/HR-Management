package com.example.hrmanagment.repository;

import com.example.hrmanagment.entity.Turnstile;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public interface TurnstileRepository extends JpaRepository<Turnstile, UUID> {

    boolean existsByName(@NotNull String name);
}
