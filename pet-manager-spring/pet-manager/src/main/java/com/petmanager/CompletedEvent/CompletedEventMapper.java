package com.petmanager.CompletedEvent;

import com.petmanager.ScheduledEvent.ScheduledEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

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
        CompletedEventEntity entity = new CompletedEventEntity();

        entity.setCompletedOn(dto.getCompletedOn());
        entity.setScheduledEvent(scheduledEventRepository.findById(dto.getScheduledEventId()).get());

        return entity;
    }
}
