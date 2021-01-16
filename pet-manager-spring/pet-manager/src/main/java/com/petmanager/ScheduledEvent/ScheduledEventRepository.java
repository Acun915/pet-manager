package com.petmanager.ScheduledEvent;

import com.petmanager.ScheduledEvent.ScheduledEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledEventRepository extends JpaRepository<ScheduledEventEntity, Long> {
}
