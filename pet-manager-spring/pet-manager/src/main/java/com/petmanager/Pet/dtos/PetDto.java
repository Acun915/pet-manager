package com.petmanager.Pet.dtos;

import com.petmanager.ScheduledEvent.dtos.ScheduledEventDto;
import lombok.Data;

import java.util.List;

@Data
public class PetDto {
    private Long id;
    private String name;
    private String type;
    private List<ScheduledEventDto> scheduledEvents;
}
