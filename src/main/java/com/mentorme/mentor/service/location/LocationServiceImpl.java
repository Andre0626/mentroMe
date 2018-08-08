package com.mentorme.mentor.service.location;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mentorme.mentor.dto.LocationDto.LocationDto;
import com.mentorme.mentor.dto.LocationDto.NewLocationDto;
import com.mentorme.mentor.entity.City;
import com.mentorme.mentor.entity.Location;
import com.mentorme.mentor.repository.CityRepo;
import com.mentorme.mentor.repository.LocationRepo;
import com.mentorme.mentor.service.location.mapper.LocationMapper;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private   LocationRepo locationRepo;
    @Autowired
    private   CityRepo cityRepo;

    public LocationServiceImpl(LocationRepo locationRepo, CityRepo cityRepo){
        this.locationRepo = locationRepo;
        this.cityRepo = cityRepo;
    }

    @Override
    public LocationDto save(NewLocationDto newLocationDto) {
       City city = getCity(newLocationDto.getCityId());
       Location mappedLocation = LocationMapper.mapEntity(newLocationDto, city);

       return LocationMapper.mapDto(locationRepo.save(mappedLocation));
    }

    private Location getLocation(Long locationId){

        return locationRepo.getOne(locationId);
    }

    private City getCity(Long cityId){

        return cityRepo.getOne(cityId);
    }
}
