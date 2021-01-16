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

        completedEventRepository.save(completedEventEntity);

        return completedEventDto;
    }
}
