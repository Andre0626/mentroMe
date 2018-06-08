package com.mentorme.mentor.service.category;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import com.mentorme.mentor.dto.Category.CategoryDto;
import com.mentorme.mentor.dto.Category.NewCategoryDto;
import com.mentorme.mentor.dto.Category.UpdateCategoryDto;
import com.mentorme.mentor.entity.Category;
import com.mentorme.mentor.repository.CategoryRepo;
import com.mentorme.mentor.service.category.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo){this.categoryRepo = categoryRepo;}

    private static LocalDateTime localDateTime = LocalDateTime.now();

    @Override
    public CategoryDto save(NewCategoryDto newCategoryDto) {

        Category category = CategoryMapper.mapEntity(newCategoryDto,localDateTime);

        Category savedCategory = categoryRepo.save(category);
        return CategoryMapper.mapDto(savedCategory);
    }

    @Override
    public CategoryDto update(UpdateCategoryDto updateCategoryDto) {

        Category category = getCategory(updateCategoryDto.getId());
                 category = CategoryMapper.mapEntity(category,updateCategoryDto,localDateTime);

        return CategoryMapper.mapDto(categoryRepo.save(category));
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categories = categoryRepo.findAll();

        return  categories.stream()
                .map(CategoryMapper::mapDto)
                .collect(Collectors.toList());
    }

    private Category getCategory(Long id){

        return  categoryRepo.getOne(id);
    }
}
