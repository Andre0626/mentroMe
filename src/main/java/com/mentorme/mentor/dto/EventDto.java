package com.mentorme.mentor.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EventDto {
   
    private Long id;
    private Long userId;
    private Long categoryId;
    private Long locationId;
    private String name;
    private String description;
    private List<SessionDto> sessionList = new ArrayList<>();
    
}
