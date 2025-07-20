package com.rayyan.eventmanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalDate;

@Getter
@Setter
public class EventAddDto {

    private Long id;
    private String title;
    private String description;
    private String location;
    private LocalDate eventDate;
    private Long createdBy;
    private Time eventTime;

}
