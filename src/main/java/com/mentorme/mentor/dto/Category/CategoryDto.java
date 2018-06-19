package com.mentorme.mentor.dto.Category;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDto {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime joinDate;
    private LocalDateTime updateDate;

}
