package com.mentorme.mentor.repository;

import com.mentorme.mentor.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
