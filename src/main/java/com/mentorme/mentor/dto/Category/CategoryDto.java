package com.mentorme.mentor.dto.Category;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import com.mentorme.mentor.dto.Event.EventDto;
import com.mentorme.mentor.entity.Event;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDto {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime joinDate;
    private LocalDateTime updateDate;
    private Collection<EventDto> eventsDto = new ArrayList<>();

}
