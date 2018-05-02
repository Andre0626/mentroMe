package com.mentorme.mentor.controller;

import com.mentorme.mentor.dto.UserDto;
import com.mentorme.mentor.service.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EventController {
    private UserService userService;

    public  EventController(UserService userService){ this.userService = userService; }

    @RequestMapping(path = "add", method = RequestMethod.GET)
    public UserDto addNewUser(){
        String name = "dan";
        Integer roleId  = 10;


        return userService.save(name,roleId);
    }


}
