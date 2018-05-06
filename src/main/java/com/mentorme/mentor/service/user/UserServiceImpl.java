package com.mentorme.mentor.service.user;

import com.mentorme.mentor.dto.UserDto;
import com.mentorme.mentor.entity.User;
import com.mentorme.mentor.repository.UserRepo;
import com.mentorme.mentor.service.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo){ this.userRepo = userRepo;}

    @Override
    public UserDto save(String name, Long roleId) {

        User userEntity = UserMapper.mapEntity(name, roleId);

        User savedUser = userRepo.save(userEntity);

        return UserMapper.mapDto(savedUser);
    }

}
