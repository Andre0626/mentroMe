package com.mentorme.mentor.service.user;

import java.util.List;
import javax.jws.soap.SOAPBinding;
import com.mentorme.mentor.dto.NewUserDto;
import com.mentorme.mentor.dto.UpdateUserDto;
import com.mentorme.mentor.dto.UserDto;
import com.mentorme.mentor.entity.User;
import com.mentorme.mentor.repository.UserRepo;
import com.mentorme.mentor.service.user.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


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
    public UserDto findById(Long id){

        return UserMapper.mapDto(userRepo.getOne(id));
    }

    @Override
    public UserDto update(UpdateUserDto updateUserDto) {
        User userEntity = getUserEntity(updateUserDto.getId());
        userEntity = UserMapper.mapEntity(userEntity, updateUserDto);

        return UserMapper.mapDto(userRepo.save(userEntity));
    }

    private User getUserEntity(Long userId) {
        User userEntity = userRepo.getOne(userId);
        Assert.notNull(userEntity, "User with id = " + userId + "does not exist");
        return userEntity;
    }
}
