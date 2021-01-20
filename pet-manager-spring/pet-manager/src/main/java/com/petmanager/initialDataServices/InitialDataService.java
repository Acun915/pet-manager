package com.petmanager.initialDataServices;

import com.petmanager.CompletedEvent.CompletedEventEntity;
import com.petmanager.CompletedEvent.CompletedEventId;
import com.petmanager.CompletedEvent.CompletedEventRepository;
import com.petmanager.Pet.PetEntity;
import com.petmanager.ScheduledEvent.ScheduledEventEntity;
import com.petmanager.Pet.PetRepository;
import com.petmanager.ScheduledEvent.ScheduledEventRepository;
import com.petmanager.ScheduledEvent.enums.Frequency;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class InitialDataService {

    private final PetRepository petRepository;
    private final ScheduledEventRepository scheduledEventRepository;
    private final CompletedEventRepository completedEventRepository;

    private PetEntity pet1;
    private PetEntity pet2;
    private PetEntity pet3;

    private ScheduledEventEntity scheduledEvent1;
    private ScheduledEventEntity scheduledEvent2;

    @PostConstruct
    public void init() {
        createDummyPets();
        createDummyScheduledEvents();
        createDummyCompletedEvents();
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
        scheduledEvent1 = new ScheduledEventEntity("feeding", Frequency.DAILY, LocalDateTime.of(2021,1,10,8,0), pet1);
        scheduledEvent2 = new ScheduledEventEntity("feeding", Frequency.DAILY, LocalDateTime.of(2021,1,10,13,0), pet1);
        ScheduledEventEntity scheduledEvent3 = new ScheduledEventEntity("feeding", Frequency.DAILY, LocalDateTime.of(2021, 1, 10, 18, 30), pet1);

        ScheduledEventEntity scheduledEvent4 = new ScheduledEventEntity("feeding", Frequency.DAILY, LocalDateTime.of(2021, 1, 10, 6, 0), pet2);
        ScheduledEventEntity scheduledEvent5 = new ScheduledEventEntity("feeding", Frequency.DAILY, LocalDateTime.of(2021, 1, 10, 16, 30), pet2);

        ScheduledEventEntity scheduledEvent6 = new ScheduledEventEntity("feeding", Frequency.DAILY, LocalDateTime.of(2021, 1, 10, 10, 30), pet3);
        ScheduledEventEntity scheduledEvent7 = new ScheduledEventEntity("feeding", Frequency.DAILY, LocalDateTime.of(2021, 1, 10, 20, 0), pet3);

        scheduledEventRepository.save(scheduledEvent1);
        scheduledEventRepository.save(scheduledEvent2);
        scheduledEventRepository.save(scheduledEvent3);
        scheduledEventRepository.save(scheduledEvent4);
        scheduledEventRepository.save(scheduledEvent5);
        scheduledEventRepository.save(scheduledEvent6);
        scheduledEventRepository.save(scheduledEvent7);
    }

    private void createDummyCompletedEvents() {
        CompletedEventEntity completedEvent1 = new CompletedEventEntity("2021-18-10", scheduledEvent1);
//        CompletedEventEntity completedEvent2 = new CompletedEventEntity(LocalDate.of(2021,1,16), scheduledEvent2);
//        CompletedEventEntity completedEvent3 = new CompletedEventEntity(LocalDate.of(2021,1,16), scheduledEvent1);

        completedEventRepository.save(completedEvent1);
//        completedEventRepository.save(completedEvent2);
//        completedEventRepository.save(completedEvent3);



    }
}
