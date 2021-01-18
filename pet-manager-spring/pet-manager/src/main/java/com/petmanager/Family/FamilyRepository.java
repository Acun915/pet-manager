package com.petmanager.Family;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FamilyRepository  extends JpaRepository<FamilyEntity, Long> {

}
