package com.mentorme.mentor.service.event.mapper;

import com.mentorme.mentor.dto.Event.EventDto;
import com.mentorme.mentor.dto.Event.NewEventDto;
import com.mentorme.mentor.dto.Event.UpdateEventDto;
import com.mentorme.mentor.entity.Category;
import com.mentorme.mentor.entity.Event;
import com.mentorme.mentor.entity.Location;
import com.mentorme.mentor.entity.Session;
import com.mentorme.mentor.service.session.mapper.SessionMapper;

import java.util.ArrayList;
import org.springframework.util.CollectionUtils;

public class EventMapper {

    public static EventDto mapDto(Event event){
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setName(event.getName());
        eventDto.setDescription(event.getDescription());
        eventDto.setCity(event.getLocations().getCity().getName());
        eventDto.setAddress(event.getLocations().getLocationAddress());
        eventDto.setLocationName(event.getLocations().getLocationName());
        eventDto.setCategoryId(event.getCategory().getId());
        eventDto.setJoinDate(event.getCreatedAt());

        if(!CollectionUtils.isEmpty(event.getSessions())){

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

        event.setCategory(category);
        event.setLocations(location);
        event.setName(newEventDto.getName());
        event.setDescription(newEventDto.getDescription());
        event.setSessions(new ArrayList<>());

        return event;
    }

    public static Event mapEntity(Event event, Category category, Location location, UpdateEventDto updateEventDto){

        event.setCategory(category);
        event.setLocations(location);
        event.setName(updateEventDto.getName());
        event.setDescription(updateEventDto.getDescription());
        event.setSessions(new ArrayList<>());

        return event;
    }

}
