package com.mentorme.mentor.service.session;

import java.util.List;
import com.mentorme.mentor.dto.Session.NewSessionDto;
import com.mentorme.mentor.dto.Session.SessionDto;
import com.mentorme.mentor.dto.Session.UpdateSessionDto;

public interface SessionService {

    SessionDto save(NewSessionDto newSessionDto);

    List<SessionDto> getSessions();

    SessionDto getOne(Long sessionId);

    SessionDto update(UpdateSessionDto updateSessionDto);

    void delete(Long sessionId);
}
