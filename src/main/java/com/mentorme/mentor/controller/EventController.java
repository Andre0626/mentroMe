package com.mentorme.mentor.controller;

import com.mentorme.mentor.dto.EventDto;
import com.mentorme.mentor.dto.NewEventDto;
import com.mentorme.mentor.entity.Event;
import com.mentorme.mentor.service.event.EventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/event")
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService){this.eventService = eventService;}


    @RequestMapping(value = "/add/{roleId}", method = RequestMethod.POST)
    public EventDto addNewUser(@PathVariable Integer roleId,
                               @RequestBody NewEventDto newEventDto) {
        if (roleId >= 2) {
            return eventService.save(newEventDto);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<EventDto> getEvents(){
        return eventService.getEvents();
    }

    @RequestMapping(value = "/events/{eventId}", method = RequestMethod.GET)
    public EventDto getEvent(@PathVariable Long eventId){
        return eventService.getEvents(eventId);
    }

}
