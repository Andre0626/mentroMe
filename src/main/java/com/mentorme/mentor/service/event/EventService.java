package com.mentorme.mentor.service.event;

import com.mentorme.mentor.dto.EventDto;

import java.util.List;

public interface EventService {
    
    EventDto save(Long categoryId,String description,Long userId, Long locationId, String name);

    List<EventDto> getEvents();
}
