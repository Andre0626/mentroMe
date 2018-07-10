package com.mentorme.mentor.service.user.mapper;

import com.mentorme.mentor.dto.User.NewUserDto;
import com.mentorme.mentor.dto.User.UpdateUserDto;
import com.mentorme.mentor.dto.User.UserDto;
import com.mentorme.mentor.entity.Role;
import com.mentorme.mentor.entity.UserEntity;

public class UserMapper {

    public static UserEntity mapEntity(NewUserDto newUserDto, Role role) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(newUserDto.getName());
        userEntity.setEmail(newUserDto.getEmail());
        userEntity.setPassword(newUserDto.getPassword());
        userEntity.setRole(role);
        userEntity.setCharacterPassword(newUserDto.getCharacterPassword());

        return userEntity;
    }

    public static UserDto mapDto(UserEntity userEntity) {

        UserDto userDto = new UserDto();

        userDto.setName(userEntity.getName());
        userDto.setId(userEntity.getId());
        userDto.setEmail(userEntity.getEmail());
        userDto.setRole(userEntity.getRole());
        userDto.setJoinDate(userEntity.getJoinDate());
        userDto.setLastUpdate(userEntity.getUpdateDataUser());

        return userDto;
    }

    public static UserEntity mapEntity(UserEntity userEntity, UpdateUserDto updateUserDto, Role role) {
        userEntity.setId(userEntity.getId());
        userEntity.setName(updateUserDto.getName());
        userEntity.setRole(role);
        userEntity.setEmail(updateUserDto.getEmail());

        return userEntity;
    }
}
