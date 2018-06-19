package com.mentorme.mentor.controller;

import java.util.List;
import com.mentorme.mentor.dto.User.NewUserDto;
import com.mentorme.mentor.dto.User.UpdateUserDto;
import com.mentorme.mentor.dto.User.UserDto;
import com.mentorme.mentor.entity.User;
import com.mentorme.mentor.service.user.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){this.userService = userService;}

    @RequestMapping(method = RequestMethod.POST )
    public UserDto create(@RequestBody NewUserDto newUserDto){

        return userService.save(newUserDto);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getAll(){

        return userService.getAll();
    }

    @RequestMapping(value ="/{id}", method = RequestMethod.GET)
    public UserDto findOne(@PathVariable("id") Long id){

        return userService.findById(id);
    }

    @RequestMapping(value ="role/{roleId}", method = RequestMethod.GET)
    public List<UserDto> findByRoleId(@PathVariable("roleId") Integer roleId){

        return userService.findByRoleId(roleId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UserDto update(@RequestBody UpdateUserDto updateUserDto){

        return userService.update(updateUserDto);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }
}
