package com.mentorme.mentor.service.event;

import com.mentorme.mentor.dto.EventDto;

public interface EventService {
    
    EventDto save(Long categoryId, Long locationId, String name, String description);
}