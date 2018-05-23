package com.mentorme.mentor.service.event;

import com.mentorme.mentor.dto.EventDto;
import com.mentorme.mentor.dto.NewEventDto;
import com.mentorme.mentor.entity.Event;

import java.util.List;

public interface EventService {
    
    EventDto save(NewEventDto newEventDto);

    List<EventDto> getEvents();

    EventDto getEvents(Long eventId);
}
