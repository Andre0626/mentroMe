package com.mentorme.mentor.service.event.mapper;

import com.mentorme.mentor.dto.EventDto;
import com.mentorme.mentor.entity.Event;
import com.mentorme.mentor.entity.Session;
import com.mentorme.mentor.service.session.mapper.SessionMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EventMapper {

    public static EventDto mapDto(Event event){
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setCategoryId(event.getCategoryId());
        eventDto.setUserId(event.getUserId());
        eventDto.setLocationId(event.getLocationId());
        eventDto.setName(event.getName());
        eventDto.setDescription(event.getDescription());

        if(!event.getSessions().isEmpty()){

            for (Session session:event.getSessions()) {
                eventDto.getSessionList().add(SessionMapper.mapDto(session));
            }
        }

        return eventDto;
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
