package com.mentorme.mentor.service.event;

import com.mentorme.mentor.dto.Event.EventDto;
import com.mentorme.mentor.dto.Event.NewEventDto;
import com.mentorme.mentor.dto.Event.UpdateEventDto;

import java.util.List;

public interface EventService {
    
    EventDto save(NewEventDto newEventDto);

    List<EventDto> getEvents();

    EventDto getEvents(Long eventId);

    EventDto update(UpdateEventDto updateEventDto);
}
