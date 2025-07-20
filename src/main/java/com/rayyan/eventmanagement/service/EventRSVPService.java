package com.rayyan.eventmanagement.service;

import com.rayyan.eventmanagement.dto.EventRSVPAddDto;
import com.rayyan.eventmanagement.dto.EventRSVPDto;
import com.rayyan.eventmanagement.dto.EventsDto;
import com.rayyan.eventmanagement.model.Event;
import com.rayyan.eventmanagement.model.EventRSVP;
import com.rayyan.eventmanagement.repositories.EventRSVPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class EventRSVPService {

    @Autowired
    EventRSVPRepository eventRSVPRepository;

    public List<EventRSVPDto> getlist() {
        List<EventRSVPDto> eventRSVPDtos = new ArrayList<>();
        List<EventRSVP> eventRSVPS = eventRSVPRepository.findAll();
        for (EventRSVP eventRSVP : eventRSVPS){
            EventRSVPDto eventRSVPDto = new EventRSVPDto();
            eventRSVPDto.setId(eventRSVP.getId());
            eventRSVPDto.setUser(eventRSVP.getUser().getName());
            eventRSVPDto.setEvent(eventRSVP.getEvent().getTitle());
            eventRSVPDto.setStatus(eventRSVP.getStatus());
            eventRSVPDtos.add(eventRSVPDto);
        }
        return eventRSVPDtos;
    }

    public String addRsvp(EventRSVPAddDto eventRSVPAddDto){
        EventRSVP eventRSVP = new EventRSVP();
        eventRSVP.setUserId(eventRSVPAddDto.getUser());
        eventRSVP.setEventId(eventRSVPAddDto.getEvent());
        eventRSVP.setStatus(eventRSVPAddDto.getStatus());

        eventRSVPRepository.save(eventRSVP);
        return "EventRSVP Successfully Added";

    }


}