package com.petmanager.ScheduledEvent;

import com.petmanager.CompletedEvent.CompletedEventEntity;
import com.petmanager.Pet.PetEntity;
import com.petmanager.ScheduledEvent.enums.Frequency;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class ScheduledEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private Frequency frequency; // daily/weekly/MONTHLY/one_time

    private Integer repeatEveryNDays;

    private LocalDateTime startDate;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "PET_ID")
    private PetEntity pet;

    @OneToMany(mappedBy = "scheduledEvent")
    private List<CompletedEventEntity> completedEvents;

    public ScheduledEventEntity(String type, Frequency frequency, LocalDateTime startDate, PetEntity pet) {
        this.type = type;
        this.frequency = frequency;
        this.startDate = startDate;
        this.pet = pet;
    }

}
