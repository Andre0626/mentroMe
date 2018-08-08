package com.mentorme.mentor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mentorme.mentor.entity.Role;

public interface RoleRepo extends JpaRepository<Role,Long> {

}
