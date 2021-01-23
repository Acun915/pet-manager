package com.petmanager.Family;

import com.petmanager.Pet.PetMapper;
import com.petmanager.jwtHandling.models.User;
import com.petmanager.jwtHandling.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FamilyMapper {

    private final PetMapper petMapper;
    private final UserRepository userRepository;


    public FamilyDto toDto(FamilyEntity entity) {
        FamilyDto dto = new FamilyDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPets(entity.getPets()
                .stream()
                .map(petMapper::toDto)
                .collect(Collectors.toList()));
        dto.setMemberNames(entity.getMembers()
                .stream()
                .map(member -> member.getUsername())
                .collect(Collectors.toList()));

        return dto;
    }

    public FamilyEntity toEntity(FamilyDto dto) {
        FamilyEntity entity = new FamilyEntity();


        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPets(dto.getPets()
                .stream()
                .map(petMapper::toEntity)
                .collect(Collectors.toList()));
        entity.setMembers(dto.getMemberNames()
                .stream()
                .map(memberName -> userRepository.findByUsername(memberName).get())
                .collect(Collectors.toList()));

        return entity;
    }
}
