package com.mentorme.mentor.dto.User;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewUserDto {

   private String userName;
   private String userEmail;
   private Integer roleId;
}
