package com.mentorme.mentor.dto.LocationDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewLocationDto {

    private Long cityId;
    private String locationAddress;
    private String locationName;
}
