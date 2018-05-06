package com.mentorme.mentor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "category_id", nullable = false)
    private Long categoryId;

    @Column(name = "location_id", nullable = false)
    private Long locationId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
