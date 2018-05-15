package com.mentorme.mentor.service.event;

import com.mentorme.mentor.dto.EventDto;
import com.mentorme.mentor.entity.Category;
import com.mentorme.mentor.entity.Event;
import com.mentorme.mentor.repository.CategoryRepo;
import com.mentorme.mentor.repository.EventRepo;
import com.mentorme.mentor.service.event.mapper.EventMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private EventRepo eventRepo;
    private CategoryRepo categoryRepo;

    private EventServiceImpl(EventRepo eventRepo,
                             CategoryRepo categoryRepo){
        this.eventRepo = eventRepo;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public EventDto save(Long categoryId,String description,Long userId, Long locationId, String name) {

        Event eventEntity = EventMapper.mapEntity(categoryId,description,userId, locationId, name);

        Event savedEvent = eventRepo.save(eventEntity);

        return EventMapper.mapDto(savedEvent);
    }

    @Override
    public List<EventDto> getEvents() {
       List<Event> events = eventRepo.findAll();
       List<EventDto> result = new ArrayList<>();

       if(!events.isEmpty()){
           for (Event event:events) {
               result.add(EventMapper.mapDto(event));
           }
       }

       return result;
    }

    private Category getCategory(Long categoryId){
       Category category;
        category = categoryRepo.getOne(categoryId);

        return category;
    }
}
