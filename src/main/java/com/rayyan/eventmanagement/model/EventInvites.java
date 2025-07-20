package com.rayyan.eventmanagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.sql.Time;

@Entity
@Table(name = "event_invites")
@Getter
@Setter
public class EventInvites {

    @Id
    @Column(name = "rsvp_id")
    private Long rsvpId;

    @Column(name = "status")
    private String status;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "event_id")
    private Long eventId;

    @Column(name = "event_date")
    private String eventDate;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "event_time")
    private Time eventTime;

}
