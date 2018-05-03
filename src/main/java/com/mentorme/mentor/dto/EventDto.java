package com.mentorme.mentor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDto {
   
    private Long id;
    private Integer categoryId;
    private Integer locationId;
    private String name;
    private String description;
    
}
