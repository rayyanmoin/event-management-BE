package com.rayyan.eventmanagement.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String role;

    @OneToMany(mappedBy = "createdBy")
    private List<Event> createdEvents;

    @OneToMany(mappedBy = "user")
    private List<EventRSVP> rsvps;


}

