package com.example.hrmanagment.repository;

import com.example.hrmanagment.entity.Role;
import com.example.hrmanagment.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRoleName(RoleName roleName);
}
