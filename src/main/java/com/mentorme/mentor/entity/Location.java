package com.mentorme.mentor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Setter
@Getter
@Entity
@Table(name = "locations")
public class Location {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "location")
    private String location;

    @Column(name = "location_address")
    private String locationAddress;
}
