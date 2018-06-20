package com.mentorme.mentor.repository;

import java.util.List;
import com.mentorme.mentor.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity,Long> {

    List<UserEntity> findAllByRoleId(Integer roleId);

    UserEntity findByUsername(String username);
}
