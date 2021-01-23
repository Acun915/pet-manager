package com.petmanager.Pet;

import com.petmanager.Family.FamilyRepository;
import com.petmanager.Pet.dtos.PetDto;
import com.petmanager.ScheduledEvent.ScheduledEventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PetMapper {

    private final ScheduledEventMapper scheduledEventMapper;
    private final FamilyRepository familyRepository;

    public PetDto toDto(PetEntity entity) {
        PetDto dto = new PetDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setType(entity.getType());
        dto.setScheduledEvents(entity.getScheduledEvents()
                .stream()
                .map(scheduledEventMapper::toDto)
                .collect(Collectors.toList()));
        dto.setFamilyId(entity.getFamily().getId());

        return dto;
    }

    public PetEntity toEntity(PetDto dto) {
        PetEntity entity = new PetEntity();

        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setFamily(familyRepository.findById(dto.getFamilyId()).get());
        try {
            entity.setScheduledEvents(dto.getScheduledEvents()
                    .stream()
                    .map(scheduledEventMapper::toEntity)
                    .collect(Collectors.toList()));
        } catch (NullPointerException e) {
            System.out.println("No schedule");
        }


        return entity;
    }
}
