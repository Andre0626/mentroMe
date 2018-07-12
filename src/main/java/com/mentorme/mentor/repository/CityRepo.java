package com.mentorme.mentor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mentorme.mentor.entity.City;

public interface CityRepo extends JpaRepository<City,Long> {
}
