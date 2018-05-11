package com.mentorme.mentor.service.session;


import com.mentorme.mentor.dto.SessionDto;
import org.springframework.stereotype.Service;

import java.sql.Date;
@Service
public class SessionServiceImpl implements SessionService {

    @Override
    public SessionDto save(Long eventId, String name, String description, Date startDate, Date endDate) {
        return null;
    }
}
