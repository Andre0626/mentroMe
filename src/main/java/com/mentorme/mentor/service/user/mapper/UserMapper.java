package com.mentorme.mentor.service.user.mapper;

import com.mentorme.mentor.dto.User.NewUserDto;
import com.mentorme.mentor.dto.User.UpdateUserDto;
import com.mentorme.mentor.dto.User.UserDto;
import com.mentorme.mentor.entity.User;

public class UserMapper {

    public static User mapEntity(NewUserDto newUserDto) {
        User user = new User();
        user.setName(newUserDto.getUserName());
        user.setRoleId(newUserDto.getRoleId());
        user.setEmail(newUserDto.getUserEmail());

        return user;
    }

    public static UserDto mapDto(User user) {

        UserDto userDto = new UserDto();

        userDto.setName(user.getName());
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setRoleId(user.getRoleId());
        userDto.setJoinDate(user.getJoinDate());
        userDto.setLastUpdate(user.getUpdateDateUser());

        return userDto;
    }

    public static User mapEntity(User user, UpdateUserDto updateUserDto) {
        user.setId(updateUserDto.getId());
        user.setName(updateUserDto.getName());
        user.setRoleId(updateUserDto.getRoleId());
        user.setEmail(updateUserDto.getEmail());

        return user;
    }
}
