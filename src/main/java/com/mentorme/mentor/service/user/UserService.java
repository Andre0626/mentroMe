package com.mentorme.mentor.service.user;

import java.util.List;
import com.mentorme.mentor.dto.NewUserDto;
import com.mentorme.mentor.dto.UpdateUserDto;
import com.mentorme.mentor.dto.UserDto;
import com.mentorme.mentor.entity.User;


public interface UserService {

    UserDto save(NewUserDto newUserDto);

    List<User> allUsers();

    UserDto findById(Long id);

    UserDto update(UpdateUserDto updateUserDto);
}
