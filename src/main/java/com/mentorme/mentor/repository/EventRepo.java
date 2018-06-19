package com.mentorme.mentor.repository;

import com.mentorme.mentor.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepo extends JpaRepository<Event,Long>{
}
