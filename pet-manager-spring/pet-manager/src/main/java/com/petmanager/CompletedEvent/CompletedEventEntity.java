package com.petmanager.CompletedEvent;

import com.petmanager.ScheduledEvent.ScheduledEventEntity;
import com.petmanager.ScheduledEvent.dtos.ScheduledEventDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@IdClass(CompletedEventId.class)
public class CompletedEventEntity {

    @Id
    private String completedOn;

    @ManyToOne
    @JoinColumn(name = "SCHEDULED_EVENT")
    @Id
    private ScheduledEventEntity scheduledEvent;

    public CompletedEventEntity(String completedOn, ScheduledEventEntity scheduledEvent) {
        this.completedOn = completedOn;
        this.scheduledEvent = scheduledEvent;
    }
}
