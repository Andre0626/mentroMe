package com.mentorme.mentor.service.session;

import com.mentorme.mentor.dto.Session.SessionDto;

import java.sql.Date;

public interface SessionService {

    SessionDto save(Long eventId, String name, String description, Date startDate, Date endDate);
}
