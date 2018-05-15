package com.mentorme.mentor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Setter
@Getter
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique = true)
    private Long id;

    @Column(name = "country_id")
    private Long countryId;

    @Column(name = "name",unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "id",nullable = false, insertable = false, updatable = false)
    private Country country;

    @OneToMany(mappedBy = "city")
    private Collection<Location> locations;

}
