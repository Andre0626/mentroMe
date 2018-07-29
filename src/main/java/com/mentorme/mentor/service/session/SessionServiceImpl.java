package com.mentorme.mentor.service.session;


import java.util.ArrayList;
import java.util.List;
import com.mentorme.mentor.dto.Session.NewSessionDto;
import com.mentorme.mentor.dto.Session.SessionDto;
import com.mentorme.mentor.entity.Event;
import com.mentorme.mentor.entity.Session;
import com.mentorme.mentor.repository.EventRepo;
import com.mentorme.mentor.repository.SessionRepo;
import com.mentorme.mentor.service.session.mapper.SessionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionRepo sessionRepo;
    @Autowired
    private EventRepo eventRepo;

    public SessionServiceImpl(SessionRepo sessionRepo, EventRepo eventRepo) {
        this.sessionRepo = sessionRepo;
        this.eventRepo = eventRepo;
    }

    @Override
    public SessionDto save(NewSessionDto newSessionDto) {

        Event event = getEvent(newSessionDto.getEventId());
        Session sessionEntity = SessionMapper.mapEntity(newSessionDto, event);

        return SessionMapper.mapDto(sessionRepo.save(sessionEntity));
    }

    @Override
    @Transactional
    public List<SessionDto> getSessions() {
        List<Session> sessionList = sessionRepo.findAll();
        List<SessionDto> sessionDtoList = new ArrayList<>();

        for (Session session : sessionList) {
            sessionDtoList.add(SessionMapper.mapDto(session));
        }

        return sessionDtoList;
    }

    private Event getEvent(Long eventId) {

        return eventRepo.getOne(eventId);
    }

}
