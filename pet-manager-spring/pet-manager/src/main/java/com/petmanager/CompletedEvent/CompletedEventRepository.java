package com.petmanager.CompletedEvent;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;


@Repository
public interface CompletedEventRepository extends JpaRepository<CompletedEventEntity, CompletedEventId> {
}
