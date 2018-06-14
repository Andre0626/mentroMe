package com.mentorme.mentor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "categories")
public class Category {

    private static LocalDateTime localDateTime = LocalDateTime.now();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "join_date")
    private LocalDateTime joinDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "category")
    private Collection<Event> events;

    @PreUpdate
    private void onPreUpdate(){
        setUpdateDate(localDateTime);
    }

    @PrePersist
    private void onPrePersist(){
        setJoinDate(localDateTime);
    }
}
