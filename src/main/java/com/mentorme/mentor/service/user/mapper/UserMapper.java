package com.mentorme.mentor.service.user.mapper;

import com.mentorme.mentor.dto.User.NewUserDto;
import com.mentorme.mentor.dto.User.UpdateUserDto;
import com.mentorme.mentor.dto.User.UserDto;
import com.mentorme.mentor.entity.UserEntity;

public class UserMapper {

    public static UserEntity mapEntity(NewUserDto newUserDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(newUserDto.getName());
        userEntity.setRoleId(newUserDto.getRoleId());
        userEntity.setEmail(newUserDto.getEmail());
        userEntity.setPassword(newUserDto.getPassword());

        return userEntity;
    }

    public static UserDto mapDto(UserEntity userEntity) {

        UserDto userDto = new UserDto();

        userDto.setName(userEntity.getUsername());
        userDto.setId(userEntity.getId());
        userDto.setEmail(userEntity.getEmail());
        userDto.setRoleId(userEntity.getRoleId());
        userDto.setJoinDate(userEntity.getJoinDate());
        userDto.setLastUpdate(userEntity.getUpdateDateUser());

        return userDto;
    }

    public static UserEntity mapEntity(UserEntity userEntity, UpdateUserDto updateUserDto) {
        userEntity.setId(updateUserDto.getId());
        userEntity.setName(updateUserDto.getName());
        userEntity.setRoleId(updateUserDto.getRoleId());
        userEntity.setEmail(updateUserDto.getEmail());

        return userEntity;
    }
}
