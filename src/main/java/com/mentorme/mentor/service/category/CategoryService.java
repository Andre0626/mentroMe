package com.mentorme.mentor.service.category;

import com.mentorme.mentor.dto.CategoryDto;

public interface CategoryService {
    CategoryDto save(String name,String description);
}
