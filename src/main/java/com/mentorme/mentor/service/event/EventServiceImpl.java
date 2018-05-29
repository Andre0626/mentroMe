package com.mentorme.mentor.service.event;

import com.mentorme.mentor.dto.EventDto;
import com.mentorme.mentor.dto.NewEventDto;
import com.mentorme.mentor.entity.*;
import com.mentorme.mentor.repository.CategoryRepo;
import com.mentorme.mentor.repository.EventRepo;
import com.mentorme.mentor.repository.LocationRepo;
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
    private LocationRepo locationRepo;

    public EventServiceImpl(EventRepo eventRepo,
                            CategoryRepo categoryRepo,
                            LocationRepo locationRepo){
        this.eventRepo = eventRepo;
        this.categoryRepo = categoryRepo;
        this.locationRepo = locationRepo;
    }

    @Override
    @Transactional
    public EventDto save(NewEventDto newEventDto) {
        
        Category category = getCategory(newEventDto.getCategoryId());
        Location location = getLocation(newEventDto.getLocationId());
        Event eventEntity = EventMapper.mapEntity(newEventDto, category,location);

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

        return categoryRepo.getOne(categoryId);
    }

    private Location getLocation(Long locationId){

        return locationRepo.getOne(locationId);
    }
}
