package com.petmanager.Pet;

import com.petmanager.Pet.dtos.PetDto;
import com.petmanager.ScheduledEvent.ScheduledEventMapper;
import com.petmanager.ScheduledEvent.ScheduledEventService;
import com.petmanager.ScheduledEvent.dtos.ScheduledEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;

    @CrossOrigin
    @GetMapping("/rest/pets")
    public List<PetDto> getAllPets() {
        return petService.getAllPets();
    }

    @CrossOrigin
    @PostMapping("/rest/pets")
    public PetDto addPet(@RequestBody PetDto petDto) {
        System.out.println(petDto);
        return petService.addPet(petDto);
    }

    @GetMapping("rest/pets/{id}")
    public PetDto getPetById(@PathVariable long id){
        return petService.getPetById(id);
    }

    @GetMapping("rest/pets/{id}/scheduledEvents")
    public List<ScheduledEventDto> getPetScheduledEvents(@PathVariable(name = "id") long petId) {
        return petService.getPetScheduledEvents(petId);
    }
}
