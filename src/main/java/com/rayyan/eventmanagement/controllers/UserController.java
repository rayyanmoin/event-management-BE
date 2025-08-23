package com.rayyan.eventmanagement.controllers;

import com.rayyan.eventmanagement.dto.EventDropDto;
import com.rayyan.eventmanagement.dto.UserDropDto;
import com.rayyan.eventmanagement.dto.UserDto;
import com.rayyan.eventmanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")

public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<UserDto> getlist(){
        return userService.getlist();
    }

    @GetMapping("/droplist")
    public List<UserDropDto> getDroplist(){
        return userService.getDroplist();
    }

    @PostMapping("/add")
    public String addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

}
