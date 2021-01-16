package com.petmanager.Pet;

import com.petmanager.Pet.dtos.PetDto;
import com.petmanager.ScheduledEvent.dtos.ScheduledEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;
    private final PetMapper petMapper;

    public List<PetDto> getAllPets() {
        return petRepository.findAll()
                .stream()
                .map(petMapper::toDto)
                .collect(Collectors.toList());
    }

    public PetDto getPetById(long id) {
        return petMapper.toDto(petRepository.findById(id).get());
    }

    public List<ScheduledEventDto> getPetScheduledEvents(long petId){
        return getPetById(petId).getScheduledEvents();
    }

    public PetDto addPet(PetDto petDto) {
        PetEntity petEntity = petMapper.toEntity(petDto);

        petRepository.save(petEntity);
        petDto.setId(petEntity.getId());

        return petDto;
    }
}
