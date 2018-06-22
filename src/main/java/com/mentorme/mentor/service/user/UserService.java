package com.mentorme.mentor.service.user;

import java.util.List;
import com.mentorme.mentor.dto.User.NewUserDto;
import com.mentorme.mentor.dto.User.UpdateUserDto;
import com.mentorme.mentor.dto.User.UserDto;
import com.mentorme.mentor.dto.User.UserSignInDto;


public interface UserService {

    UserDto save(NewUserDto newUserDto);

    List<UserDto> getAll();

    UserDto findById(Long id);

    List<UserDto> findByRoleId(Integer roleId);

    UserDto update(UpdateUserDto updateUserDto);

    void delete(Long id);
}
