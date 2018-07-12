package com.mentorme.mentor.dto.LocationDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLocationDto {

    private Long id;
    private String locationAddress;
    private String locationName;
    private Long cityId;

}
