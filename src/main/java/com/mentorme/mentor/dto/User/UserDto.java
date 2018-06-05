package com.mentorme.mentor.dto.User;


import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class UserDto {

    private Long id;
    private Integer roleId;
    private Date joinDate;
    private String name;
    private String email;

}

