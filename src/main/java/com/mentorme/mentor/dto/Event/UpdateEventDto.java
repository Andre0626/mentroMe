package com.mentorme.mentor.dto.Event;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateEventDto {

    private Long id;
    private Long categoryId;
    private String description;
    private String name;
    private Long cityId;
    private Long  locationId;
    private String locationName;
    private String locationAddress;

}