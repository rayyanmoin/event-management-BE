package com.rayyan.eventmanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventRSVPDto {

    private Long id;
    private String user;
    private String event;
    private String status;

}
