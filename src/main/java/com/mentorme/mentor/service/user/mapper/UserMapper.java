package com.mentorme.mentor.service.user.mapper;

import com.mentorme.mentor.dto.NewUserDto;
import com.mentorme.mentor.dto.UserDto;
import com.mentorme.mentor.entity.User;

public class UserMapper {

    public static User mapEntity(NewUserDto newUserDto) {
        User user = new User();
        user.setName(newUserDto.getUserName());
        user.setRoleId(newUserDto.getRoleId());
        user.setEmail(newUserDto.getUserEmail());
        user.setJoinDate(newUserDto.getJoinDate());

        return user;
    }

    public static UserDto mapDto(User user) {

        UserDto userDto = new UserDto();

        userDto.setName(user.getName());
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setRoleId(user.getRoleId());

        return userDto;
    }
}
