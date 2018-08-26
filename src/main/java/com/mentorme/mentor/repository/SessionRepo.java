package com.mentorme.mentor.repository;

import com.mentorme.mentor.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepo extends JpaRepository<Session,Long> {
}
