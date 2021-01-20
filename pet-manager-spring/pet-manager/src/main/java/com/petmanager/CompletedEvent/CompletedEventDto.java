package com.petmanager.CompletedEvent;

import com.petmanager.ScheduledEvent.dtos.ScheduledEventDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class CompletedEventDto {
    private String completedOn;
    private Long scheduledEventId;
}
