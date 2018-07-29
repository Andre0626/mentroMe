package com.mentorme.mentor.dto.Session;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewSessionDto {
    Long eventId;
    String description;
    String name;
    String startDate;
    String endDate;
}
