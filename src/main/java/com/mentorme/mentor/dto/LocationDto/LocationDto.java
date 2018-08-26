package com.mentorme.mentor.dto.LocationDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDto {

    private Long id;
    private String locationAddress;
    private String locationName;
    private Long cityId;
}
