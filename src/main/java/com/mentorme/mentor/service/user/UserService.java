package com.mentorme.mentor.service.user;

import com.mentorme.mentor.dto.UserDto;

import java.sql.Date;

public interface UserService {

    UserDto save(Integer roleId,String userName,String userEmail,Date joinDate);

}
