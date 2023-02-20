package com.example.hrmanagment.repository;

import com.example.hrmanagment.entity.InOut;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface InOutRepository extends JpaRepository<InOut, UUID> {

}
