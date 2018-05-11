package com.mentorme.mentor.service.event.mapper;

import com.mentorme.mentor.dto.EventDto;
import com.mentorme.mentor.entity.Event;

public class EventMapper {

    public static EventDto mapDto(Event event){
        EventDto eventDto = new EventDto();
        eventDto.setCategoryId(event.getCategoryId());
        eventDto.setUserId(event.getUserId());
        eventDto.setLocationId(event.getLocationId());
        eventDto.setName(event.getName());
        eventDto.setDescription(event.getDescription());
        return  eventDto;
    }

    public static Event mapEntity(Long categoryId,String description,Long userId, Long locationId, String name){
        Event event = new Event();
        event.setCategoryId(categoryId);
        event.setUserId(userId);
        event.setLocationId(locationId);
        event.setName(name);
        event.setDescription(description);

        return event;
    }
}
