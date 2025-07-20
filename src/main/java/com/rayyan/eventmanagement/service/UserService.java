package com.rayyan.eventmanagement.service;

import com.rayyan.eventmanagement.dto.UserDto;
import com.rayyan.eventmanagement.model.User;
import com.rayyan.eventmanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<UserDto> getlist(){
        List<UserDto> userDtos = new ArrayList<>();

        List<User> users = userRepository.findAll();
        for (User user : users) {
            UserDto dto = new UserDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());
            dto.setRole(user.getRole());

            // Add the DTO to the list
            userDtos.add(dto);
        }
        return  userDtos;
    }

    public String addUser(UserDto userDto){
    Optional<User> exisitingUser = Optional.of(new User());
    User user = new User();

    if(userDto.getId() != null) {
        exisitingUser = userRepository.findById(userDto.getId());
        user = exisitingUser.get();
    }

    user.setName(userDto.getName());
    user.setEmail(userDto.getEmail());
    user.setRole(userDto.getRole());

    userRepository.save(user);
    return "User Added/Edited Succcesfully";
    }


}