package com.mentorme.mentor.service.event;

import com.mentorme.mentor.dto.EventDto;
import com.mentorme.mentor.dto.NewEventDto;
import com.mentorme.mentor.entity.*;
import com.mentorme.mentor.repository.CategoryRepo;
import com.mentorme.mentor.repository.EventRepo;
import com.mentorme.mentor.service.event.mapper.EventMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private EventRepo eventRepo;
    private CategoryRepo categoryRepo;

    public EventServiceImpl(EventRepo eventRepo,
                             CategoryRepo categoryRepo){
        this.eventRepo = eventRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    @Transactional
    public EventDto save(NewEventDto newEventDto) {

        Category category = getCategory(newEventDto.getCategoryId());

        Event eventEntity = EventMapper.mapEntity(newEventDto, category);

        Event savedEvent = eventRepo.save(eventEntity);

        return EventMapper.mapDto(savedEvent);
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE )
    public List<EventDto> getEvents() {
       List<Event> events = eventRepo.findAll();
       List<EventDto> result = new ArrayList<>();

       if(CollectionUtils.isEmpty(events)){
           for (Event event:events) {
               result.add(EventMapper.mapDto(event));
           }
       }

       return result;
    }

    @Override
    @Transactional(readOnly = true)
    public  EventDto getEvents(Long eventId){
        Event event = eventRepo.getOne(eventId);

        return EventMapper.mapDto(event);
    }


    private Category getCategory(Long categoryId){
       Category category;
        category = categoryRepo.getOne(categoryId);

        return category;
    }
}
