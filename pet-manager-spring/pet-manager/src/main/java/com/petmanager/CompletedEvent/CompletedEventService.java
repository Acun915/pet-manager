package com.petmanager.CompletedEvent;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CompletedEventService {

    private final CompletedEventRepository completedEventRepository;
    private final CompletedEventMapper completedEventMapper;

    public CompletedEventDto addCompletedEvent(CompletedEventDto completedEventDto) {
        CompletedEventEntity completedEventEntity = completedEventMapper.toEntity(completedEventDto);

        System.out.println(completedEventDto.getCompletedOn());
        System.out.println(completedEventEntity.getCompletedOn());

        CompletedEventEntity completedEventEntity2 =completedEventRepository.save(completedEventEntity);

        System.out.println(completedEventEntity2.getCompletedOn());

        return completedEventDto;
    }

    public void deleteCompletedEventById(CompletedEventId id) {
        completedEventRepository.deleteById(id);
    }
}
