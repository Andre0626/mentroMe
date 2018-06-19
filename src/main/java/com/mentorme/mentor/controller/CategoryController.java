package com.mentorme.mentor.controller;

import java.util.List;
import com.mentorme.mentor.dto.Category.CategoryDto;
import com.mentorme.mentor.dto.Category.NewCategoryDto;
import com.mentorme.mentor.dto.Category.UpdateCategoryDto;
import com.mentorme.mentor.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){this.categoryService = categoryService;}

    @RequestMapping(method = RequestMethod.POST)
    public CategoryDto create(@RequestBody NewCategoryDto newCategoryDto){

        return categoryService.save(newCategoryDto);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public CategoryDto update(@RequestBody UpdateCategoryDto updateCategoryDto){

        return categoryService.update(updateCategoryDto);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<CategoryDto> findAll(){

        return categoryService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CategoryDto findOne(@PathVariable Long id){

        return categoryService.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void delete(@PathVariable Long id){

         categoryService.delete(id);
    }
}
