package com.mentorme.mentor.entity;

import javax.persistence.*;

@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
