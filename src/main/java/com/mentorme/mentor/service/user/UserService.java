package com.mentorme.mentor.service.user;

import com.mentorme.mentor.dto.UserDto;

public interface UserService {

    UserDto save(String name,Integer roleId);

}
