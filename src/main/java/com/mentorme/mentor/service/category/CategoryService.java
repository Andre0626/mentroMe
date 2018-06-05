package com.mentorme.mentor.service.category;

import com.mentorme.mentor.dto.Category.CategoryDto;

public interface CategoryService {
    CategoryDto save(String name,String description);
}
