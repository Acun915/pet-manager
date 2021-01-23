package com.petmanager.jwtHandling.repository;

import java.util.Optional;

import com.petmanager.Family.FamilyEntity;
import com.petmanager.jwtHandling.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Modifying
    @Query("update User u set u.family = :family where u.id = :id")
    void updateFamily(@Param(value = "id") long id, @Param(value = "family") FamilyEntity family);
}