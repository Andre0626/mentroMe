package com.mentorme.mentor.repository;

import java.util.List;
import com.mentorme.mentor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    List<User> findAllByRoleId(Integer roleId);
}
