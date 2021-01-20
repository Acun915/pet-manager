package com.petmanager.ScheduledEvent;

import com.petmanager.CompletedEvent.CompletedEventMapper;
import com.petmanager.Pet.PetRepository;
import com.petmanager.ScheduledEvent.dtos.ScheduledEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ScheduledEventMapper {

    private final PetRepository petRepository;
    private final CompletedEventMapper completedEventMapper;

    public ScheduledEventDto toDto(ScheduledEventEntity entity) {
        ScheduledEventDto dto = new ScheduledEventDto();

        dto.setId(entity.getId());
        dto.setType(entity.getType());
        dto.setFrequency(entity.getFrequency());
        dto.setRepeatEveryNDays(entity.getRepeatEveryNDays());
        dto.setStartDate(entity.getStartDate());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setPetId(entity.getPet().getId());
        dto.setCompletedEvents(entity.getCompletedEvents()
                .stream()
                .map(completedEventMapper::toDto)
                .collect(Collectors.toList()));

        return dto;
    }

    public ScheduledEventEntity toEntity(ScheduledEventDto dto) {
        ScheduledEventEntity entity = new ScheduledEventEntity();

        entity.setType(dto.getType());
        entity.setFrequency(dto.getFrequency());
        entity.setRepeatEveryNDays(dto.getRepeatEveryNDays());
        entity.setStartDate(dto.getStartDate());
        entity.setPet(petRepository.findById(dto.getPetId()).get());

//        entity.setCompletedEvents(dto.getCompletedEvents()
//                .stream()
//                .map(completedEventMapper::toEntity)
//                .collect(Collectors.toList()));

        return entity;
    }
}
