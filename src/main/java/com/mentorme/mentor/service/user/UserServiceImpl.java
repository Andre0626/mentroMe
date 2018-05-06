package com.mentorme.mentor.service.user;

import com.mentorme.mentor.dto.UserDto;
import com.mentorme.mentor.entity.User;
import com.mentorme.mentor.repository.UserRepo;
import com.mentorme.mentor.service.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo){ this.userRepo = userRepo;}

    @Override
    public UserDto save(Integer roleId,String userName,String userEmail,Date joinDate) {

        User userEntity = UserMapper.mapEntity(roleId,userName,userEmail,joinDate);

        User savedUser = userRepo.save(userEntity);

        return UserMapper.mapDto(savedUser);
    }

}
