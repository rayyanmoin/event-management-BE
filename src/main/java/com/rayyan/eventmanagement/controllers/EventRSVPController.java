package com.rayyan.eventmanagement.controllers;

import com.rayyan.eventmanagement.dto.EventRSVPAddDto;
import com.rayyan.eventmanagement.dto.EventRSVPDto;
import com.rayyan.eventmanagement.dto.EventsDto;
import com.rayyan.eventmanagement.dto.UserDto;
import com.rayyan.eventmanagement.service.EventRSVPService;
import com.rayyan.eventmanagement.service.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventrsvp")
@CrossOrigin(origins = "http://localhost:3000")

public class EventRSVPController {

    private final EventRSVPService eventRSVPService;

    public EventRSVPController(EventRSVPService eventRSVPService) {
        this.eventRSVPService = eventRSVPService;
    }

    @GetMapping("/list")
    public List<EventRSVPDto> getlist(){
        return eventRSVPService.getlist();
    }

    @PostMapping("/add")
    public String addRsvp(@RequestBody EventRSVPAddDto eventRSVPAddDto){
        return eventRSVPService.addRsvp(eventRSVPAddDto);
    }

}
