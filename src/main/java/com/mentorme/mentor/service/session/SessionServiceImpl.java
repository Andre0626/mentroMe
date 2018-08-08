package com.mentorme.mentor.service.session;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import com.mentorme.mentor.dto.Session.NewSessionDto;
import com.mentorme.mentor.dto.Session.SessionDto;
import com.mentorme.mentor.dto.Session.UpdateSessionDto;
import com.mentorme.mentor.entity.Event;
import com.mentorme.mentor.entity.Session;
import com.mentorme.mentor.repository.EventRepo;
import com.mentorme.mentor.repository.SessionRepo;
import com.mentorme.mentor.service.session.mapper.SessionMapper;
import com.mentorme.mentor.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SessionServiceImpl implements SessionService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

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

    @Override
    @Transactional
    public SessionDto getOne(Long sessionId){

        Session session = getSession(sessionId);

        return SessionMapper.mapDto(session);
    }

    @Override
    @Transactional
    public void delete(Long sessionId) {
        String sessionName = getSession(sessionId).getName();

        sessionRepo.deleteById(sessionId);

        LOGGER.info(sessionName + " was deleted");
    }

    @Override
    public SessionDto update(UpdateSessionDto updateSessionDto){
        Session session = getSession(updateSessionDto.getId());

        //@TODO update session
        return null;
    }

    @Transactional(readOnly = true)
    public Event getEvent(Long eventId) {

        return eventRepo.getOne(eventId);
    }

    @Transactional(readOnly = true)
    public Session getSession(Long sessionId) {

        return sessionRepo.getOne(sessionId);
    }

}
