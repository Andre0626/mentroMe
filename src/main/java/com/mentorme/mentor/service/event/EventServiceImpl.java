package com.mentorme.mentor.service.event;

import com.mentorme.mentor.dto.EventDto;
import com.mentorme.mentor.entity.Event;
import com.mentorme.mentor.repository.EventRepo;
import com.mentorme.mentor.service.event.mapper.EventMapper;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    private EventRepo eventRepo;
    private EventServiceImpl(EventRepo eventRepo){this.eventRepo = eventRepo;}

    @Override
    public EventDto save(Long categoryId, Long locationId, String name, String description) {

        Event eventEntity = EventMapper.mapEntity(categoryId, locationId, name, description);

        Event savedEvent = eventRepo.save(eventEntity);

        return EventMapper.mapDto(savedEvent);
    }
}
