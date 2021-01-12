package com.petmanager.services;

import com.petmanager.Pet.PetEntity;
import com.petmanager.ScheduledEvent.ScheduledEventEntity;
import com.petmanager.Pet.PetRepository;
import com.petmanager.ScheduledEvent.ScheduledEventRepository;
import com.petmanager.ScheduledEvent.enums.Frequency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class InitialDataService {

    private final PetRepository petRepository;
    private final ScheduledEventRepository scheduledEventRepository;

    private PetEntity pet1;
    private PetEntity pet2;
    private PetEntity pet3;

    @PostConstruct
    public void init() {
        createDummyPets();
        createDummyScheduledEvents();
    }

    private void createDummyPets() {
        pet1 = new PetEntity("Burek", "dog");
        pet2 = new PetEntity("Reksio", "dog");
        pet3 = new PetEntity("Mruczek", "cat");

        petRepository.save(pet1);
        petRepository.save(pet2);
        petRepository.save(pet3);
    }

    private void createDummyScheduledEvents() {
        ScheduledEventEntity scheduledEvent1 = new ScheduledEventEntity("feeding", Frequency.DAILY, LocalDateTime.of(2021,1,10,8,0), pet1);
        ScheduledEventEntity scheduledEvent2 = new ScheduledEventEntity("feeding", Frequency.DAILY, LocalDateTime.of(2021,1,10,13,0), pet1);
        ScheduledEventEntity scheduledEvent3 = new ScheduledEventEntity("feeding", Frequency.DAILY, LocalDateTime.of(2021,1,10,18,30), pet1);

        ScheduledEventEntity scheduledEvent4 = new ScheduledEventEntity("feeding", Frequency.DAILY, LocalDateTime.of(2021,1,10,6,0), pet2);
        ScheduledEventEntity scheduledEvent5 = new ScheduledEventEntity("feeding", Frequency.DAILY, LocalDateTime.of(2021,1,10,16,30), pet2);

        ScheduledEventEntity scheduledEvent6 = new ScheduledEventEntity("feeding", Frequency.DAILY, LocalDateTime.of(2021,1,10,10,30), pet3);
        ScheduledEventEntity scheduledEvent7 = new ScheduledEventEntity("feeding", Frequency.DAILY, LocalDateTime.of(2021,1,10,20,0), pet3);

        scheduledEventRepository.save(scheduledEvent1);
        scheduledEventRepository.save(scheduledEvent2);
        scheduledEventRepository.save(scheduledEvent3);
        scheduledEventRepository.save(scheduledEvent4);
        scheduledEventRepository.save(scheduledEvent5);
        scheduledEventRepository.save(scheduledEvent6);
        scheduledEventRepository.save(scheduledEvent7);
    }
}
