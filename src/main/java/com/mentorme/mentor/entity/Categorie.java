package com.mentorme.mentor.entity;

import javax.persistence.*;

@Table(name = "categories")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
