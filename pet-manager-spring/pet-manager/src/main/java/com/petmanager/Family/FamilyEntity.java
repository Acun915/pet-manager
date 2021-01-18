package com.petmanager.Family;

import com.petmanager.Pet.PetEntity;
import com.petmanager.User.UserEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class FamilyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "FAMILY_ID")
    private List<PetEntity> pets;

    @OneToMany
    @JoinColumn(name = "FAMILY_ID")
    private List<UserEntity> members;
}
