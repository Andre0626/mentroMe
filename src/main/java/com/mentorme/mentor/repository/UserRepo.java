package com.mentorme.mentor.repository;

import com.mentorme.mentor.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {


}
