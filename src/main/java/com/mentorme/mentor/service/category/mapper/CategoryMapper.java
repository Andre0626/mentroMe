package com.mentorme.mentor.service.category.mapper;

import com.mentorme.mentor.dto.Category.CategoryDto;
import com.mentorme.mentor.entity.Category;

public class CategoryMapper {

  public   static CategoryDto mapDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());

        return categoryDto;
    }

   public static Category mapEntity(String name,String description){
        Category category = new Category();
        category.setDescription(description);
        category.setName(name);

        return category;
    }
}
