package com.petmanager.ScheduledEvent.dtos;

import com.petmanager.ScheduledEvent.enums.Frequency;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduledEventDto {
    long id;
    private String type;
    private Frequency frequency;
    private Integer repeatEveryNDays;
    private LocalDateTime startDate;
    private LocalDateTime createdAt;
    private long petId;
}
