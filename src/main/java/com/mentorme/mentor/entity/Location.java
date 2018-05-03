package com.mentorme.mentor.entity;

import javax.persistence.*;

@Table(name = "locations")
public class Location {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "location")
    private String location;

    @Column(name = "location_addres")
    private String locationAddres;
}
