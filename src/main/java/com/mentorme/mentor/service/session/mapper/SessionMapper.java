package com.mentorme.mentor.service.session.mapper;

import com.mentorme.mentor.dto.SessionDto;
import com.mentorme.mentor.entity.Session;

import java.sql.Date;

public class SessionMapper {

   public static SessionDto mapDto(Session session){
        SessionDto sessionDto = new SessionDto();
        session.setId(session.getId());
        session.setEventId(session.getEventId());
        session.setName(session.getName());
        session.setDescription(session.getDescription());
        session.setStartDate(session.getStartDate());
        session.setEndDate(session.getStartDate());

        return sessionDto;
    }

   public static Session mapEntity(Long eventId,String name,String description,Date startDate,Date endDate){
        Session session = new Session();
        session.setEventId(eventId);
        session.setName(name);
        session.setDescription(description);
        session.setStartDate(startDate);
        session.setEndDate(endDate);

        return session;
    }
}
