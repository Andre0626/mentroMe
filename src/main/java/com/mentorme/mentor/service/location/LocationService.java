package com.mentorme.mentor.service.location;

import com.mentorme.mentor.dto.LocationDto.LocationDto;
import com.mentorme.mentor.dto.LocationDto.NewLocationDto;

public interface LocationService {

    LocationDto save(NewLocationDto newUserDto);
}
