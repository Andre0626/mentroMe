package com.mentorme.mentor.service.event;

import com.mentorme.mentor.dto.EventDto;

public interface EventService {
    
    EventDto save(Long categoryId,String description,Long userId, Long locationId, String name);
}
