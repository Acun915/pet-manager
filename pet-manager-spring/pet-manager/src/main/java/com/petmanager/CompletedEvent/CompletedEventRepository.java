package com.petmanager.CompletedEvent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedEventRepository extends JpaRepository<CompletedEventEntity, Long> {
}
