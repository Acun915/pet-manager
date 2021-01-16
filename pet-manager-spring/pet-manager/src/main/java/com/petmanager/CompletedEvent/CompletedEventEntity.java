package com.petmanager.CompletedEvent;

import com.petmanager.ScheduledEvent.ScheduledEventEntity;
import com.petmanager.ScheduledEvent.dtos.ScheduledEventDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class CompletedEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate completedOn;

    @ManyToOne
    @JoinColumn(name = "SCHEDULED_EVENT_ID")
    private ScheduledEventEntity scheduledEvent;

    public CompletedEventEntity(LocalDate completedOn, ScheduledEventEntity scheduledEvent) {
        this.completedOn = completedOn;
        this.scheduledEvent = scheduledEvent;
    }
}
