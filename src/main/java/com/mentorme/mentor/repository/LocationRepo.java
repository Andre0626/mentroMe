package com.mentorme.mentor.repository;

import com.mentorme.mentor.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location,Long> {
}
