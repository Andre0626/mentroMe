package com.mentorme.mentor.dto.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserDto {

    private Long id;
    private Long roleId;
    private String name;
    private String email;

}
