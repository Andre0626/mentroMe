package com.mentorme.mentor.service.category.mapper;

import com.mentorme.mentor.dto.Category.CategoryDto;
import com.mentorme.mentor.dto.Category.NewCategoryDto;
import com.mentorme.mentor.dto.Category.UpdateCategoryDto;
import com.mentorme.mentor.entity.Category;

public class CategoryMapper {

  public   static CategoryDto mapDto(Category category){
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setJoinDate(category.getJoinDate());
        categoryDto.setUpdateDate(category.getUpdateDate());

        return categoryDto;
    }

   public static Category mapEntity(NewCategoryDto newCategoryDto){
        Category category = new Category();

        category.setDescription(newCategoryDto.getDescription());
        category.setName(newCategoryDto.getName());

        return category;
    }

    public static Category mapEntity(Category category, UpdateCategoryDto UpdateCategoryDto){

        category.setDescription(UpdateCategoryDto.getDescription());
        category.setName(UpdateCategoryDto.getName());
        category.setJoinDate(category.getJoinDate());

        return category;
    }
}
