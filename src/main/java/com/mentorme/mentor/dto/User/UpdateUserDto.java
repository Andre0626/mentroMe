package com.mentorme.mentor.dto.User;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserDto {

    private Long id;
    private Date updateDate;
    private Integer roleId;
    private String name;
    private String email;

}
