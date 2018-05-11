package com.mentorme.mentor.controller;

import com.mentorme.mentor.dto.SessionDto;
import com.mentorme.mentor.service.session.SessionService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping(path = "/sessions")
public class SessionController {
    private SessionService sessionService;
    public SessionController(SessionService sessionService){this.sessionService = sessionService;}

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public SessionDto addNewSession(@RequestParam(value = "eventId") Long eventId,
                                    @RequestParam(value = "description") String description,
                                    @RequestParam(value = "name") String name,
                                    @RequestParam(value = "startDate") Date startDate,
                                    @RequestParam(value = "endDate") Date endDate){

        return null;
    }
}
