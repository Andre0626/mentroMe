package com.mentorme.mentor.service.event.mapper;

import com.mentorme.mentor.dto.EventDto;
import com.mentorme.mentor.dto.NewEventDto;
import com.mentorme.mentor.entity.Category;
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
        eventDto.setCategoryId(event.getCategory().getId());
        eventDto.setUserId(event.getUserId());
        eventDto.setLocationId(event.getCategory().getId());
        eventDto.setName(event.getName());
        eventDto.setDescription(event.getDescription());

        if(!event.getSessions().isEmpty()){

            for (Session session:event.getSessions()) {
                eventDto.getSessionList().add(SessionMapper.mapDto(session));
            }
        } else {
            eventDto.setSessionList(new ArrayList<>());
        }

        return eventDto;
    }

    public static Event mapEntity(NewEventDto newEventDto, Category category){
        Event event = new Event();
        event.setCategoryId(category.getId());
        event.setUserId(newEventDto.getUserId());
        event.setLocationId(newEventDto.getLocationId());
        event.setName(newEventDto.getName());
        event.setDescription(newEventDto.getDescription());
        event.setCategory(category);

        return event;
    }
}
