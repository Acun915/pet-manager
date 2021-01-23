package com.petmanager.Family;

import com.petmanager.Pet.dtos.PetDto;
import lombok.Data;

import java.util.List;

@Data
public class FamilyDto {
    private Long id;
    private String name;
    private List<PetDto> pets;
    private List<String> memberNames;

}
