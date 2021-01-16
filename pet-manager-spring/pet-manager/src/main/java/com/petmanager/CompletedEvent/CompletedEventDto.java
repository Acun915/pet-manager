package com.petmanager.CompletedEvent;

import com.petmanager.ScheduledEvent.dtos.ScheduledEventDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CompletedEventDto {
    private LocalDate completedOn;
    private Long scheduledEventId;
}
