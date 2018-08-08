package com.mentorme.mentor.controller;

import java.util.List;
import com.mentorme.mentor.dto.Session.NewSessionDto;
import com.mentorme.mentor.dto.Session.SessionDto;
import com.mentorme.mentor.dto.Session.UpdateSessionDto;
import com.mentorme.mentor.service.session.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @RequestMapping(method = RequestMethod.POST)
    public SessionDto addNewSession(@RequestBody NewSessionDto newSessionDto) {

        return sessionService.save(newSessionDto);
    }

    @GetMapping
    public List<SessionDto> getSessions() {

        return sessionService.getSessions();
    }

    @GetMapping(path = "/{sessionId}")
    public SessionDto getSessions(@PathVariable Long sessionId) {

        return sessionService.getOne(sessionId);
    }


    @DeleteMapping(path = "/{sessionId}")
    public void delete (@PathVariable Long sessionId){

        sessionService.delete(sessionId);
    }

    @PutMapping
    public SessionDto update(@RequestBody UpdateSessionDto updateSessionDto){

        return sessionService.update(updateSessionDto);
    }
}
