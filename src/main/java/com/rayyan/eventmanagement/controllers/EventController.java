package com.rayyan.eventmanagement.controllers;

import com.rayyan.eventmanagement.dto.EventAddDto;
import com.rayyan.eventmanagement.dto.EventDropDto;
import com.rayyan.eventmanagement.dto.EventsDto;
import com.rayyan.eventmanagement.dto.UserDto;
import com.rayyan.eventmanagement.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@CrossOrigin(origins = "http://localhost:3000")

public class EventController {

     private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/list")
    public List<EventsDto> getlist(){
        return eventService.getlist();
    }

    @GetMapping("/droplist")
    public List<EventDropDto> getDroplist(){
        return eventService.getDroplist();
    }

    @PostMapping("/add")
    public String addEvent(@RequestBody EventAddDto eventAddDto){
        return eventService.addEvent(eventAddDto);
    }
}
