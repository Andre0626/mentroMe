package com.mentorme.mentor.controller;

import com.mentorme.mentor.dto.Event.EventDto;
import com.mentorme.mentor.dto.Event.NewEventDto;
import com.mentorme.mentor.service.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/add/{roleId}", method = RequestMethod.POST)
    public EventDto addUser(@PathVariable Integer roleId,
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
