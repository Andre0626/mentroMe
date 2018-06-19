package com.mentorme.mentor.dto.Event;


import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewEventDto {

   private Long categoryId;
   private String description;
   private Long userId;
   private Long locationId;
   private String name;
   private LocalDateTime userCreatedAt;
}
