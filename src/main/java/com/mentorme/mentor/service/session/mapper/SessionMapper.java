package com.mentorme.mentor.service.session.mapper;

import com.mentorme.mentor.dto.Session.NewSessionDto;
import com.mentorme.mentor.dto.Session.SessionDto;
import com.mentorme.mentor.entity.Event;
import com.mentorme.mentor.entity.Session;

import static com.mentorme.mentor.DateTimeFormat.DateTimeFormat.convertStringToDate;

public class SessionMapper {

    public static SessionDto mapDto(Session session) {
        SessionDto sessionDto = new SessionDto();
        sessionDto.setId(session.getId());
        sessionDto.setEventId(session.getEvent().getId());
        sessionDto.setName(session.getName());
        sessionDto.setDescription(session.getDescription());
        sessionDto.setEndDate(session.getEndDate());
        sessionDto.setStartDate(session.getStartDate());


        return sessionDto;
    }

    public static Session mapEntity(NewSessionDto newSessionDto, Event event) {
        Session session = new Session();
        session.setName(newSessionDto.getName());
        session.setDescription(newSessionDto.getDescription());
        session.setEvent(event);
        session.setStartDate(convertStringToDate(newSessionDto.getStartDate()));
        session.setEndDate(convertStringToDate(newSessionDto.getEndDate()));

        return session;
    }
}
