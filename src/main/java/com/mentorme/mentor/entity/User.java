package com.mentorme.mentor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name ="id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role_id", nullable = false)
    private Integer roleId;

    @Column(name = "name", length = 200)
    private String name;

    @Column(name = "email", length = 200)
    private String email;

    @Column(name = "join_date")
    private LocalDateTime joinDate;

    @Column(name = "last_update")
    private LocalDateTime updateDateUser;
}
