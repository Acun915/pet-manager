package com.petmanager.ScheduledEvent;

import com.petmanager.ScheduledEvent.dtos.ScheduledEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ScheduledEventController {

    private final ScheduledEventService scheduledEventService;

    @CrossOrigin
    @PostMapping("rest/pets/{id}/scheduledEvents")
    public ScheduledEventDto addPetScheduledEvent(@PathVariable(name = "id") long petId, @RequestBody ScheduledEventDto scheduledEventDto) {
        return scheduledEventService.addScheduledEvent(scheduledEventDto);
    }
}
