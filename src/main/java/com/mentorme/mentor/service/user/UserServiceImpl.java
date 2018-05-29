package com.mentorme.mentor.service.user;

import java.util.List;
import com.mentorme.mentor.dto.NewUserDto;
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
    public UserDto save(NewUserDto newUserDto) {

        User userEntity = UserMapper.mapEntity(newUserDto);

        User savedUser = userRepo.save(userEntity);

        return UserMapper.mapDto(savedUser);
    }

    @Override
    public List<User> allUsers() {
        return userRepo.findAll();
    }

    @Override
    public UserDto userById(Long id){

        return UserMapper.mapDto(userRepo.getOne(id));
    }

}
