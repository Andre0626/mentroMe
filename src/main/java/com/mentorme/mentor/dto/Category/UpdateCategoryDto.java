package com.mentorme.mentor.dto.Category;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateCategoryDto {

    private Long id;
    private String name;
    private String description;
}
