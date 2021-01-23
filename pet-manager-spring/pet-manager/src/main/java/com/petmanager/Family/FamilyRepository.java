package com.petmanager.Family;

import com.petmanager.jwtHandling.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FamilyRepository  extends JpaRepository<FamilyEntity, Long> {

    @Modifying
    @Query("update FamilyEntity f set f.members = :members where f.id = :id")
    void updateMembers(@Param(value = "id") long id, @Param(value = "members") List<User> members);
}
