package com.petmanager.ScheduledEvent;

import com.petmanager.Pet.PetRepository;
import com.petmanager.ScheduledEvent.dtos.ScheduledEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduledEventMapper {

    private final PetRepository petRepository;

    public ScheduledEventDto toDto(ScheduledEventEntity entity) {
        ScheduledEventDto dto = new ScheduledEventDto();

        dto.setId(entity.getId());
        dto.setType(entity.getType());
        dto.setFrequency(entity.getFrequency());
        dto.setRepeatEveryNDays(entity.getRepeatEveryNDays());
        dto.setStartDate(entity.getStartDate());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setPetId(entity.getPet().getId());

        return dto;
    }

    public ScheduledEventEntity toEntity(ScheduledEventDto dto) {
        ScheduledEventEntity entity = new ScheduledEventEntity();

        entity.setType(dto.getType());
        entity.setFrequency(dto.getFrequency());
        entity.setRepeatEveryNDays(dto.getRepeatEveryNDays());
        entity.setStartDate(dto.getStartDate());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setPet(petRepository.findById(dto.getPetId()).get());

        return entity;
    }
}
