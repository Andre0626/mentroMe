package com.mentorme.mentor.service.user.mapper;

import com.mentorme.mentor.dto.UserDto;
import com.mentorme.mentor.entity.User;

import java.sql.Date;

public class UserMapper {

    public static User mapEntity(Integer roleId,String name,String email,Date joinDate) {
        User user = new User();
        user.setName(name);
        user.setRoleId(roleId);
        user.setEmail(email);
        user.setJoinDate(joinDate);

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
