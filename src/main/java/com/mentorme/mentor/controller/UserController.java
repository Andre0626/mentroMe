package com.mentorme.mentor.controller;

import java.util.List;
import com.mentorme.mentor.dto.NewUserDto;
import com.mentorme.mentor.dto.UpdateUserDto;
import com.mentorme.mentor.dto.UserDto;
import com.mentorme.mentor.entity.User;
import com.mentorme.mentor.service.user.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){this.userService = userService;}

    @RequestMapping(method = RequestMethod.POST )
    public UserDto addUser(@RequestBody NewUserDto newUserDto){

        return userService.save(newUserDto);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> allUsers(){

        return userService.allUsers();
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public UserDto userById(@PathVariable Long id){

        return userService.findById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UserDto update(@RequestBody UpdateUserDto updateUserDto){

        return userService.update(updateUserDto);
    }
}
