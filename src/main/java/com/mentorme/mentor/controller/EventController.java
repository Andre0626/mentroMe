package com.mentorme.mentor.controller;

import com.mentorme.mentor.dto.EventDto;
import com.mentorme.mentor.service.event.EventService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/event")
public class EventController {

    private EventService eventService;

    public EventController(EventService eventService){this.eventService = eventService;}


    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public EventDto addNewUser(@RequestParam(name = "categoryId") Long categoryId,
                               @RequestParam(name = "description", required = false) String eventDescription,
                               @RequestParam(name = "locationId") Long locationId,
                               @RequestParam(name = "userId") Long userId,
                               @RequestParam(name = "name") String eventName) {

        return eventService.save(categoryId,eventDescription,locationId,userId,eventName);
    }


}
