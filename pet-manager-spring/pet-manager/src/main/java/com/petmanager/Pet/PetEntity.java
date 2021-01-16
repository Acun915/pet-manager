package com.petmanager.Pet;

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

    public PetEntity(String name, String type) {
        this.name = name;
        this.type = type;
    }

}
