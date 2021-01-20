package com.petmanager.jwtHandling.repository;

import java.util.Optional;

import com.petmanager.jwtHandling.models.ERole;
import com.petmanager.jwtHandling.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
