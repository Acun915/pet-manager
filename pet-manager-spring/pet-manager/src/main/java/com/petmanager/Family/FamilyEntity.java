package com.petmanager.Family;

import com.petmanager.Pet.PetEntity;
import com.petmanager.jwtHandling.models.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class FamilyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "family")
    private List<PetEntity> pets;

    @OneToMany(mappedBy = "family")
    private List<User> members;
}
