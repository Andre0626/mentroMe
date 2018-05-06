package com.mentorme.mentor.controller;

import com.mentorme.mentor.dto.UserDto;
import com.mentorme.mentor.service.user.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){this.userService = userService;}

    @RequestMapping(path = "/add", method = RequestMethod.GET )
    public UserDto addNewUser(@RequestParam(name = "name") String userName,
                              @RequestParam(name = "email") String userEmail,
                              @RequestParam(name = "joinDate")Date joinDate,
                              @RequestParam(name = "roleId") Integer roleId){


        return userService.save(roleId,userName,userEmail,joinDate);
    }
}
