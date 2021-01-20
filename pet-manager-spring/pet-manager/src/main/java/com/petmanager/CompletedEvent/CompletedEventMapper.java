package com.petmanager.CompletedEvent;

import com.petmanager.ScheduledEvent.ScheduledEventEntity;
import com.petmanager.ScheduledEvent.ScheduledEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class CompletedEventMapper {

    private final ScheduledEventRepository scheduledEventRepository;

    public CompletedEventDto toDto(CompletedEventEntity entity) {
        CompletedEventDto dto = new CompletedEventDto();

        dto.setCompletedOn(entity.getCompletedOn());
        dto.setScheduledEventId(entity.getScheduledEvent().getId());

        return dto;
    }

    public CompletedEventEntity toEntity(CompletedEventDto dto) {
        String completedOn = dto.getCompletedOn();

        ScheduledEventEntity scheduledEvent = scheduledEventRepository.findById(dto.getScheduledEventId()).get();

        CompletedEventEntity entity = new CompletedEventEntity(completedOn, scheduledEvent);

        return entity;
    }
}
