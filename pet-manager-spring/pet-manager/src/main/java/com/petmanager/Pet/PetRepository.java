package com.petmanager.Pet;

import com.petmanager.Family.FamilyEntity;
import com.petmanager.Pet.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {

    List<PetEntity> findAllByFamily(FamilyEntity family);
}
