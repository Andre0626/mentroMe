package com.mentorme.mentor.service.user;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.logging.*;
import java.util.stream.Collectors;
import com.mentorme.mentor.dto.User.NewUserDto;
import com.mentorme.mentor.dto.User.UpdateUserDto;
import com.mentorme.mentor.dto.User.UserDto;
import com.mentorme.mentor.entity.User;
import com.mentorme.mentor.repository.UserRepo;
import com.mentorme.mentor.service.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());
    private static LocalDateTime localDateTime = LocalDateTime.now();

    @Autowired
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo){ this.userRepo = userRepo;}

    @Override
    public UserDto save(NewUserDto newUserDto) {

        User userEntity = UserMapper.mapEntity(newUserDto,localDateTime);

        User savedUser = userRepo.save(userEntity);

        return UserMapper.mapDto(savedUser);
    }

    @Override
    public List<UserDto> getAll() {
        List<User> allUsers = userRepo.findAll();

        return   allUsers.stream()
                .sorted(Comparator.comparing(User::getJoinDate))
                .map(UserMapper::mapDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id){

        return UserMapper.mapDto(userRepo.getOne(id));
    }

    @Override
    public List<UserDto> findByRoleId(Integer roleId){
        List<User> users = userRepo.findAllByRoleId(roleId);

        return users.stream()
                .map(UserMapper::mapDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto update(UpdateUserDto updateUserDto) {
        User userEntity = getUserEntity(updateUserDto.getId());
        userEntity = UserMapper.mapEntity(userEntity, updateUserDto, localDateTime);

        return UserMapper.mapDto(userRepo.save(userEntity));
    }

    @Override public void delete(Long id){
        userRepo.deleteById(id);
        LOGGER.info("successful delete user id :" + id);
    }

    private User getUserEntity(Long userId) {
        User userEntity = userRepo.getOne(userId);
        Assert.notNull(userEntity, "User with id = " + userId + "does not exist");
        return userEntity;
    }

}
