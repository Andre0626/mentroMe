package com.mentorme.mentor.service.session;

import java.util.List;
import com.mentorme.mentor.dto.Session.NewSessionDto;
import com.mentorme.mentor.dto.Session.SessionDto;

public interface SessionService {

    SessionDto save(NewSessionDto newSessionDto);

    List<SessionDto> getSessions();
}
