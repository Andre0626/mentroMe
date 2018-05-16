package com.mentorme.mentor.controller;

import com.mentorme.mentor.dto.EventDto;
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
                               @RequestParam(value = "categoryId")  Long categoryId,
                               @RequestParam(value = "description", required = false) String eventDescription,
                               @RequestParam(value = "locationId") Long locationId,
                               @RequestParam(value = "userId") Long userId,
                               @RequestParam(value = "name") String eventName) {
        if (roleId >= 2) {
            return eventService.save(categoryId, eventDescription, locationId, userId, eventName);
        } else {
            return null;
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<EventDto> getEvents(){
        return eventService.getEvents();
    }

}
