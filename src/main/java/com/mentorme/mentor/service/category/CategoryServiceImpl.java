package com.mentorme.mentor.service.category;

import com.mentorme.mentor.dto.CategoryDto;
import com.mentorme.mentor.entity.Category;
import com.mentorme.mentor.repository.CategoryRepo;
import com.mentorme.mentor.service.category.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo){this.categoryRepo = categoryRepo;}
    @Override
    public CategoryDto save(String name, String description) {

        Category category = CategoryMapper.mapEntity(name, description);

        Category savedCategory = categoryRepo.save(category);
        return CategoryMapper.mapDto(savedCategory);
    }
}
