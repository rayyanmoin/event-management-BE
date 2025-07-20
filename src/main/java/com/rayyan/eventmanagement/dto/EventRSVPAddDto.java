package com.rayyan.eventmanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventRSVPAddDto {

    private Long id;
    private Long user;
    private Long event;
    private String status;

}
