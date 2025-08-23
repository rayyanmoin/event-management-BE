package com.rayyan.eventmanagement.service;

import com.rayyan.eventmanagement.controllers.EventController;
import com.rayyan.eventmanagement.dto.EventAddDto;
import com.rayyan.eventmanagement.dto.EventDropDto;
import com.rayyan.eventmanagement.dto.EventsDto;
import com.rayyan.eventmanagement.dto.UserDto;
import com.rayyan.eventmanagement.model.Event;
import com.rayyan.eventmanagement.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class EventService {

    @Autowired
    EventRepository eventRepository;


    public List<EventsDto> getlist() {
        List<EventsDto> eventsDtos = new ArrayList<>();
        List<Event> events = eventRepository.findAll();
        for (Event event : events) {
            EventsDto eventsDto = new EventsDto();
            eventsDto.setId(event.getId());
            eventsDto.setTitle(event.getTitle());
            eventsDto.setDescription(event.getDescription());
            eventsDto.setLocation(event.getLocation());
            eventsDto.setEventDate(event.getEventDate());
            eventsDto.setCreatedBy(event.getCreatedBy().getName());
            eventsDto.setEventTime(event.getEventTime());

            eventsDtos.add(eventsDto);
        }
    return eventsDtos;

    }

    public List<EventDropDto> getDroplist() {
        List<EventDropDto> eventdropDtos = new ArrayList<>();
        List<Event> events = eventRepository.findAll();
        for (Event event : events) {
            EventDropDto eventsDto = new EventDropDto();
            eventsDto.setId(event.getId());
            eventsDto.setTitle(event.getTitle());
            eventdropDtos.add(eventsDto);
        }
        return eventdropDtos;
    }

    public String addEvent(EventAddDto eventAddDto){
        Optional <Event> existingEvent = Optional.of(new Event());
        Event event = new Event();
        if(eventAddDto.getId() != null){
            existingEvent = eventRepository.findById(eventAddDto.getId());
            event = existingEvent.get();
        }
        event.setTitle(eventAddDto.getTitle());
        event.setDescription(eventAddDto.getDescription());
        event.setLocation(eventAddDto.getLocation());
        event.setEventDate(eventAddDto.getEventDate());
        event.setCreatedById(eventAddDto.getCreatedBy());
        event.setEventTime(eventAddDto.getEventTime());

        eventRepository.save(event);
        return "Event Add/Edited Successfully";
    }

}