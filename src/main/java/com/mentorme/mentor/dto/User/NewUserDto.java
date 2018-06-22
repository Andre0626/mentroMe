package com.mentorme.mentor.dto.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewUserDto {

   private String name;
   private String email;
   private String password;
   private Integer roleId;

}
