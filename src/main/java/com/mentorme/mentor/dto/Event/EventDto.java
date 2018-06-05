package com.mentorme.mentor.dto.Event;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import com.mentorme.mentor.dto.Session.SessionDto;

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
