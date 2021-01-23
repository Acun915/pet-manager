package com.petmanager.Family;

import com.petmanager.Pet.PetEntity;
import com.petmanager.jwtHandling.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class FamilyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "family")
    private List<PetEntity> pets;

    @OneToMany(mappedBy = "family")
    private List<User> members;

    public FamilyEntity(String name) {
        this.name = name;
    }
}
