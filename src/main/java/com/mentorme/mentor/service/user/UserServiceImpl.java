package com.mentorme.mentor.service.user;

import java.util.Comparator;
import java.util.List;
import java.util.logging.*;
import java.util.stream.Collectors;
import com.mentorme.mentor.dto.User.NewUserDto;
import com.mentorme.mentor.dto.User.UpdateUserDto;
import com.mentorme.mentor.dto.User.UserDto;
import com.mentorme.mentor.entity.UserEntity;
import com.mentorme.mentor.repository.UserRepo;
import com.mentorme.mentor.service.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

    @Autowired
    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo){ this.userRepo = userRepo;}

    @Override
    public UserDto save(NewUserDto newUserDto) {

        UserEntity userEntityEntity = UserMapper.mapEntity(newUserDto);

        UserEntity savedUserEntity = userRepo.save(userEntityEntity);

        return UserMapper.mapDto(savedUserEntity);
    }

    @Override
    public List<UserDto> getAll() {
        List<UserEntity> allUserEntities = userRepo.findAll();

        return   allUserEntities.stream()
                .sorted(Comparator.comparing(UserEntity::getJoinDate))
                .map(UserMapper::mapDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id){

        return UserMapper.mapDto(userRepo.getOne(id));
    }

    @Override
    public List<UserDto> findByRoleId(Integer roleId){
        List<UserEntity> userEntities = userRepo.findAllByRoleId(roleId);

        return userEntities.stream()
                .map(UserMapper::mapDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto update(UpdateUserDto updateUserDto) {
        UserEntity userEntityEntity = getUserEntity(updateUserDto.getId());
        userEntityEntity = UserMapper.mapEntity(userEntityEntity, updateUserDto);

        return UserMapper.mapDto(userRepo.save(userEntityEntity));
    }

    @Override public void delete(Long id){
        userRepo.deleteById(id);
        LOGGER.info("successful delete user id :" + id);
    }

    private UserEntity getUserEntity(Long userId) {
        UserEntity userEntityEntity = userRepo.getOne(userId);
        Assert.notNull(userEntityEntity, "UserEntity with id = " + userId + "does not exist");
        return userEntityEntity;
    }

}
