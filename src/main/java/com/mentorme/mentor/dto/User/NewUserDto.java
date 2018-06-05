package com.mentorme.mentor.dto.User;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewUserDto {

   private String userName;
   private String userEmail;
   private Date joinDate;
   private Integer roleId;
}
