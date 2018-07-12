package com.mentorme.mentor.service.event;

import com.mentorme.mentor.dto.Event.EventDto;
import com.mentorme.mentor.dto.Event.NewEventDto;
import com.mentorme.mentor.dto.Event.UpdateEventDto;
import com.mentorme.mentor.entity.*;
import com.mentorme.mentor.repository.CategoryRepo;
import com.mentorme.mentor.repository.CityRepo;
import com.mentorme.mentor.repository.EventRepo;
import com.mentorme.mentor.repository.LocationRepo;
import com.mentorme.mentor.service.event.mapper.EventMapper;
import com.mentorme.mentor.service.location.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private LocationRepo locationRepo;
    @Autowired
    private CityRepo cityRepo;

    public EventServiceImpl(EventRepo eventRepo,
                            CategoryRepo categoryRepo,
                            LocationRepo locationRepo,
                            CityRepo cityRepo) {
        this.eventRepo = eventRepo;
        this.categoryRepo = categoryRepo;
        this.locationRepo = locationRepo;
        this.cityRepo = cityRepo;
    }

    @Override
    @Transactional
    public EventDto save(NewEventDto newEventDto) {
        Location location = getLocation(newEventDto.getLocationId());

        if (location == null){
        //@TODO add new location if not exist
        }
        Category category = getCategory(newEventDto.getCategoryId());

        Event eventEntity = EventMapper.mapEntity(newEventDto, category, location);

        Event savedEvent = eventRepo.save(eventEntity);

        return EventMapper.mapDto(savedEvent);
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.SERIALIZABLE)
    public List<EventDto> getEvents() {
        List<Event> events = eventRepo.findAll();
        List<EventDto> result = new ArrayList<>();

        if (!CollectionUtils.isEmpty(events)) {
            for (Event event : events) {
                result.add(EventMapper.mapDto(event));
            }
        }

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public EventDto getEvents(Long eventId) {
        Event event = eventRepo.getOne(eventId);

        return EventMapper.mapDto(event);
    }

    @Override
    public EventDto update(UpdateEventDto updateEventDto) {
        Event event = getEvent(updateEventDto.getId());
        Location location = getLocation(updateEventDto.getLocationId());
        City city = getCity(updateEventDto.getCityId());
        Category category = getCategory(updateEventDto.getCategoryId());

        Location updateLocation = LocationMapper.mapEntity(location, updateEventDto, city);
        Event updateEvent = EventMapper.mapEntity(event, category, updateLocation, updateEventDto);

        return EventMapper.mapDto(eventRepo.save(updateEvent));
    }

    @Transactional(readOnly = true)
    public Category getCategory(Long categoryId) {

        return categoryRepo.getOne(categoryId);
    }

    @Transactional(readOnly = true)
    public Event getEvent(Long categoryId) {
        Event event = eventRepo.getOne(categoryId);

        return event;
    }

    @Transactional(readOnly = true)
    public Location getLocation(Long locationId) {

        return locationRepo.getOne(locationId);
    }

    @Transactional(readOnly = true)
    public City getCity(Long cityId) {

        return cityRepo.getOne(cityId);
    }
}
