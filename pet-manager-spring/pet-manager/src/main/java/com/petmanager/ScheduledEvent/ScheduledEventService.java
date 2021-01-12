package com.petmanager.ScheduledEvent;

import com.petmanager.ScheduledEvent.dtos.ScheduledEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduledEventService {

    private final ScheduledEventRepository scheduledEventRepository;
    private final ScheduledEventMapper scheduledEventMapper;

    public ScheduledEventDto getById (long id) {
        return scheduledEventMapper.toDto(scheduledEventRepository.findById(id).get());
    }

    public ScheduledEventDto addScheduledEvent(ScheduledEventDto scheduledEventDto) {
        ScheduledEventEntity scheduledEventEntity = scheduledEventMapper.toEntity(scheduledEventDto);

        scheduledEventRepository.save(scheduledEventEntity);

        scheduledEventDto.setId(scheduledEventEntity.getId());

        return scheduledEventDto;
    }
}
