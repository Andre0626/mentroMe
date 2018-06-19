package com.mentorme.mentor.dto.User;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {

    private Long id;
    private Integer roleId;
    private LocalDateTime joinDate;
    private String name;
    private String email;
    private LocalDateTime lastUpdate;
}

