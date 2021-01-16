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
    public CompletedEventDto addCompletedEvent(@PathVariable(name = "id") Long petId, @RequestBody CompletedEventDto completedEventDto) {
        return completedEventService.addCompletedEvent(completedEventDto);
    }

    @CrossOrigin
    @DeleteMapping("rest/pets/{id}/scheduledEvents/completedEvents")
    public void deleteCompletedEventById(Long id) {
        completedEventService.deleteCompletedEventById(id);
    }
}
