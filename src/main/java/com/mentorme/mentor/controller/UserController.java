package com.mentorme.mentor.controller;

import java.util.List;
import com.mentorme.mentor.dto.User.NewUserDto;
import com.mentorme.mentor.dto.User.UpdateUserDto;
import com.mentorme.mentor.dto.User.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserService userService,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public void signUp(@RequestBody NewUserDto newUserDto) {

        newUserDto.setCharacterPassword(newUserDto.getPassword());
        newUserDto.setPassword(bCryptPasswordEncoder.encode(newUserDto.getPassword()));

        userService.save(newUserDto);
    }

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public List<UserDto> getAll() {

        return userService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public UserDto findOne(@PathVariable("id") Long id) {

        return userService.findById(id);
    }

    @RequestMapping(value = "role/{roleId}", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<UserDto> findByRoleId(@PathVariable("roleId") Long roleId) {

        return userService.findByRoleId(roleId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UserDto update(@RequestBody UpdateUserDto updateUserDto) {

        return userService.update(updateUserDto);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }
}
