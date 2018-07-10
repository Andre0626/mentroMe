package com.mentorme.mentor.dto.User;


import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import com.mentorme.mentor.entity.Role;

@Getter
@Setter
public class UserDto {

    private long id;
    private LocalDateTime joinDate;
    private String name;
    private String email;
    private LocalDateTime lastUpdate;
    private Role role;
}

