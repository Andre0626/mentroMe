package com.mentorme.mentor.service.category;

import java.util.List;
import com.mentorme.mentor.dto.Category.CategoryDto;
import com.mentorme.mentor.dto.Category.NewCategoryDto;
import com.mentorme.mentor.dto.Category.UpdateCategoryDto;

public interface CategoryService {

    CategoryDto save(NewCategoryDto newCategoryDto);

    CategoryDto update(UpdateCategoryDto updateCategoryDto);

    List<CategoryDto> findAll();

    CategoryDto findOne(Long id);

    void delete(Long id);
}
