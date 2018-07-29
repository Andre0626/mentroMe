package com.mentorme.mentor.dto.Session;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class SessionDto {

    private Long id;
    private Long eventId;
    private String description;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
