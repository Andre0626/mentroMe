package com.mentorme.mentor.service.location.mapper;

import com.mentorme.mentor.dto.Event.UpdateEventDto;
import com.mentorme.mentor.dto.LocationDto.LocationDto;
import com.mentorme.mentor.dto.LocationDto.NewLocationDto;
import com.mentorme.mentor.entity.City;
import com.mentorme.mentor.entity.Location;

public class LocationMapper {

    public static Location mapEntity(Location location, UpdateEventDto updateEventDto, City city){

        location.setId(location.getId());
        location.setLocationName(updateEventDto.getLocationName());
        location.setLocationAddress(updateEventDto.getLocationAddress());
        location.setCity(city);

        return location;
    }

    public static Location mapEntity(NewLocationDto newLocationDto, City city){
        Location location = new Location();

        location.setLocationName(newLocationDto.getLocationName());
        location.setLocationAddress(newLocationDto.getLocationAddress());
        location.setCity(city);

        return location;
    }

    public static LocationDto mapDto(Location location){
       LocationDto locationDto = new LocationDto();

        locationDto.setLocationName(location.getLocationName());
        locationDto.setLocationAddress(location.getLocationAddress());
        locationDto.setCityId(location.getCity().getId());

        return locationDto;
    }
}
