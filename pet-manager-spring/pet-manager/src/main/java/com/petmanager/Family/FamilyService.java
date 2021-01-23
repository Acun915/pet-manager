package com.petmanager.Family;

import com.petmanager.jwtHandling.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyService {

    private final FamilyRepository familyRepository;
    private final FamilyMapper familyMapper;

    public FamilyDto getFamilyById(Long id) {
        return familyMapper.toDto(familyRepository.findById(id).get());
    }

    public FamilyDto addFamily(FamilyDto familyDto) {
        FamilyEntity familyEntity = familyMapper.toEntity(familyDto);

        familyEntity = familyRepository.save(familyEntity);

        familyDto.setId(familyEntity.getId());

        return familyDto;
    }


}
