package com.petmanager.Pet;

import com.petmanager.Family.FamilyEntity;
import com.petmanager.ScheduledEvent.ScheduledEventEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String type;

    @OneToMany(mappedBy = "pet")
    private List<ScheduledEventEntity> scheduledEvents;

    @ManyToOne
    @JoinColumn(name = "FAMILY_ID")
    private FamilyEntity family;

    public PetEntity(String name, String type, FamilyEntity family) {
        this.name = name;
        this.type = type;
        this.family = family;
    }

}
