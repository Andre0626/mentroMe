package com.mentorme.mentor.controller;

import com.mentorme.mentor.dto.Category.CategoryDto;
import com.mentorme.mentor.service.category.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){this.categoryService = categoryService;}

    @RequestMapping(name = "/add", method = RequestMethod.PUT)
    public CategoryDto addNewCategory(@RequestParam(name = "name") String name,
                                      @RequestParam(name = "description", required = false) String description){

        return categoryService.save(name, description);
    }
}
