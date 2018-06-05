package com.mentorme.mentor.service.event.mapper;

import com.mentorme.mentor.dto.Event.EventDto;
import com.mentorme.mentor.dto.Event.NewEventDto;
import com.mentorme.mentor.entity.Category;
import com.mentorme.mentor.entity.Event;
import com.mentorme.mentor.entity.Location;
import com.mentorme.mentor.entity.Session;
import com.mentorme.mentor.service.session.mapper.SessionMapper;

import java.util.ArrayList;

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
        } else {
            eventDto.setSessionList(new ArrayList<>());
        }

        return eventDto;
    }

    public static Event mapEntity(NewEventDto newEventDto, Category category, Location location){
        Event event = new Event();
        event.setCategoryId(category.getId());
        event.setUserId(newEventDto.getUserId());
        event.setLocationId(location.getId());
        event.setLocations(location);
        event.setName(newEventDto.getName());
        event.setDescription(newEventDto.getDescription());
        event.setCategory(category);
        event.setSessions(new ArrayList<>());

        return event;
    }
}
