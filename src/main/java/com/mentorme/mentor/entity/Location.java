package com.mentorme.mentor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Getter
@Setter
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

    @OneToMany(mappedBy = "locations")
    private Collection<Event> events;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private City city;
}
