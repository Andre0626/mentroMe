package com.mentorme.mentor.controller;

import com.mentorme.mentor.dto.Event.EventDto;
import com.mentorme.mentor.dto.Event.NewEventDto;
import com.mentorme.mentor.dto.Event.UpdateEventDto;
import com.mentorme.mentor.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/event")
public class EventController {

   @Autowired
   private EventService eventService;

   public EventController(EventService eventService){this.eventService = eventService;}

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public EventDto addEvent(@RequestBody NewEventDto newEventDto) {

            return eventService.save(newEventDto);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<EventDto> getEvents(){
        return eventService.getEvents();
    }

    @RequestMapping(value = "/{eventId}", method = RequestMethod.GET)
    public EventDto getEvent(@PathVariable Long eventId){
        return eventService.getEvents(eventId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public EventDto update(@RequestBody UpdateEventDto updateEventDto){

        return eventService.update(updateEventDto);
    }

}
