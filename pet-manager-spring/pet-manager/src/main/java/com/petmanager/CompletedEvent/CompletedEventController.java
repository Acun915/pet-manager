package com.petmanager.CompletedEvent;

import com.petmanager.ScheduledEvent.dtos.ScheduledEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CompletedEventController {
    private final CompletedEventService completedEventService;

    @CrossOrigin
    @PostMapping("rest/pets/{id}/scheduledEvents/completedEvents")
    public CompletedEventDto addCompletedEvent(@RequestBody CompletedEventDto completedEventDto) {
        return completedEventService.addCompletedEvent(completedEventDto);
    }

    @CrossOrigin
    @DeleteMapping("rest/pets/{petId}/scheduledEvents/completedEvents/{id}")
    public void deleteCompletedEventById(@PathVariable Long id) {
        completedEventService.deleteCompletedEventById(id);
    }
}
