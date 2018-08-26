package com.mentorme.mentor.service.category.mapper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;
import org.springframework.util.CollectionUtils;
import com.mentorme.mentor.dto.Category.CategoryDto;
import com.mentorme.mentor.dto.Category.NewCategoryDto;
import com.mentorme.mentor.dto.Category.UpdateCategoryDto;
import com.mentorme.mentor.dto.Event.EventDto;
import com.mentorme.mentor.entity.Category;
import com.mentorme.mentor.entity.Event;
import com.mentorme.mentor.service.event.mapper.EventMapper;

public class CategoryMapper {

    public static CategoryDto mapDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setJoinDate(category.getJoinDate());
        categoryDto.setUpdateDate(category.getUpdateDate());

        if (!CollectionUtils.isEmpty(category.getEvents())) {

            for (Event event : category.getEvents()) {
                categoryDto.getEventsDto().add(EventMapper.mapDto(event));
            }
        } else {
            categoryDto.setEventsDto(new ArrayList<>());
        }

        categoryDto.getEventsDto()
                .stream()
                .sorted(Comparator.comparing(EventDto::getJoinDate))
                .collect(Collectors.toList());

        return categoryDto;
    }

    public static Category mapEntity(NewCategoryDto newCategoryDto) {
        Category category = new Category();

        category.setDescription(newCategoryDto.getDescription());
        category.setName(newCategoryDto.getName());

        return category;
    }

    public static Category mapEntity(Category category, UpdateCategoryDto UpdateCategoryDto) {

        category.setDescription(UpdateCategoryDto.getDescription());
        category.setName(UpdateCategoryDto.getName());
        category.setJoinDate(category.getJoinDate());

        return category;
    }
}
