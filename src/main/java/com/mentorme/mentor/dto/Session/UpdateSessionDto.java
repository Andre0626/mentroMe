package com.mentorme.mentor.dto.Session;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateSessionDto {

    private Long id;
    private Long eventId;
    private String description;
    private String name;
    private String startDate;
    private String endDate;

}
