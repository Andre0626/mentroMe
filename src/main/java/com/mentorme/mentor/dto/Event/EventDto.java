package com.mentorme.mentor.dto.Event;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.mentorme.mentor.dto.Session.SessionDto;

@Getter
@Setter
public class EventDto {
   
    private Long id;
    private Long categoryId;
    private String name;
    private String description;
    private String locationName;
    private String address;
    private String city;
    private LocalDateTime joinDate;
    private List<SessionDto> sessionList = new ArrayList<>();
    
}
