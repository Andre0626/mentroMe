package com.mentorme.mentor.service.category;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import com.mentorme.mentor.dto.Category.CategoryDto;
import com.mentorme.mentor.dto.Category.NewCategoryDto;
import com.mentorme.mentor.dto.Category.UpdateCategoryDto;
import com.mentorme.mentor.entity.Category;
import com.mentorme.mentor.repository.CategoryRepo;
import com.mentorme.mentor.service.category.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static Logger logger = Logger.getLogger(CategoryServiceImpl.class.getName());

    @Autowired
    private CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    @Transactional
    public CategoryDto save(NewCategoryDto newCategoryDto) {

        Category category = CategoryMapper.mapEntity(newCategoryDto);

        Category savedCategory = categoryRepo.save(category);
        return CategoryMapper.mapDto(savedCategory);
    }

    @Override
    @Transactional
    public CategoryDto update(UpdateCategoryDto updateCategoryDto) {

        Category category = getCategory(updateCategoryDto.getId());
        category = CategoryMapper.mapEntity(category, updateCategoryDto);

        return CategoryMapper.mapDto(categoryRepo.save(category));
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepo.findAll();

        return categories.stream()
                .map(CategoryMapper::mapDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findOne(Long id) {
        Category category = categoryRepo.getOne(id);

        return CategoryMapper.mapDto(category);
    }


    private Category getCategory(Long id) {

        return categoryRepo.getOne(id);
    }

    @Transactional
    public void delete(Long id) {

        categoryRepo.delete(getCategory(id));
        logger.info("category " + getCategory(id).getName() + "was deleted");
    }
}
