package com.mentorme.mentor.service.session;


import com.mentorme.mentor.dto.SessionDto;
import com.mentorme.mentor.entity.Session;
import com.mentorme.mentor.repository.SessionRepo;
import com.mentorme.mentor.service.session.mapper.SessionMapper;
import org.springframework.stereotype.Service;

import java.sql.Date;
@Service
public class SessionServiceImpl implements SessionService {
    private SessionRepo sessionRepo;
    public SessionServiceImpl(SessionRepo sessionRepo){this.sessionRepo = sessionRepo;}

    @Override
    public SessionDto save(Long eventId, String name, String description, Date startDate, Date endDate) {

        Session sessionEntity = SessionMapper.mapEntity(eventId,name,description,startDate,endDate);

        return SessionMapper.mapDto(sessionRepo.save(sessionEntity));
    }
}
