package com.petmanager.CompletedEvent;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CompletedEventController {
    private final CompletedEventService completedEventService;

    @CrossOrigin
    @PostMapping("rest/completedEvents")
    public CompletedEventDto addCompletedEvent(@RequestBody CompletedEventDto completedEventDto) {
        return completedEventService.addCompletedEvent(completedEventDto);
    }

    @CrossOrigin
    @DeleteMapping("rest/completedEvents")
    public void deleteCompletedEventById(@RequestBody CompletedEventId id) {
        completedEventService.deleteCompletedEventById(new CompletedEventId(id.getCompletedOn(), id.getScheduledEvent()));
    }
}
