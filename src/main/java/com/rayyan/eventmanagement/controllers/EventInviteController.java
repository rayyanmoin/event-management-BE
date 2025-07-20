package com.rayyan.eventmanagement.controllers;

import com.rayyan.eventmanagement.model.EventInvites;
import com.rayyan.eventmanagement.repositories.EventInviteRepository;
import com.rayyan.eventmanagement.service.EmailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/event-invites")
public class EventInviteController {

    private final EventInviteRepository eventInviteRepository;
    private final EmailService emailService;

    public EventInviteController(EventInviteRepository eventInviteRepository, EmailService emailService) {
        this.eventInviteRepository = eventInviteRepository;
        this.emailService = emailService;
    }

    @GetMapping("/send/{eventId}")
    public String sendInvitations(@PathVariable Long eventId) {
        List<EventInvites> invites = eventInviteRepository.findAll()
                .stream()
                .filter(invite -> invite.getEventId().equals(eventId))
                .collect(Collectors.toList());

        if (invites.isEmpty()) {
            return "No invites found for event ID: " + eventId;
        }

        String eventTitle = invites.get(0).getTitle();
        String description = invites.get(0).getDescription();
        String location = invites.get(0).getLocation();
        String eventDate = invites.get(0).getEventDate();
        String eventTime = invites.get(0).getEventTime().toString();
        // Or use LocalDateTime if available

        List<String> recipientEmails = invites.stream()
                .map(EventInvites::getEmail)
                .distinct()
                .collect(Collectors.toList());

        emailService.sendEventInvites(eventTitle, description, location, eventDate, eventTime,recipientEmails);

        return "Emails sent to users for event ID: " + eventId;
    }
}
