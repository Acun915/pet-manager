package com.petmanager.CompletedEvent;

import com.petmanager.ScheduledEvent.ScheduledEventEntity;
import com.petmanager.ScheduledEvent.ScheduledEventService;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class CompletedEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate completedOn;

    @ManyToOne
    @JoinColumn(name = "SCHEDULED_EVENT_ID")
    private ScheduledEventEntity scheduledEvent;
}
