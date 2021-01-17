package com.petmanager.ScheduledEvent.dtos;

import com.petmanager.CompletedEvent.CompletedEventDto;
import com.petmanager.ScheduledEvent.enums.Frequency;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ScheduledEventDto {
    private Long id;
    private String type;
    private Frequency frequency;
    private Integer repeatEveryNDays;
    private LocalDateTime startDate;
    private LocalDateTime createdAt;
    private Long petId;
    private List<CompletedEventDto> completedEvents;
}
